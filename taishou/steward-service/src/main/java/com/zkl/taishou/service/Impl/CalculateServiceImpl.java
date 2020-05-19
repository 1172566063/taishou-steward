package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.PO.CalculateResultPO;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.common.constants.*;
import com.zkl.taishou.common.entity.CalculateCardinal;
import com.zkl.taishou.common.entity.CalculateRecord;
import com.zkl.taishou.common.utils.CommonUtils;
import com.zkl.taishou.dao.calculate.CalculateCardinalMapper;
import com.zkl.taishou.dao.calculate.CalculateRecordMapper;
import com.zkl.taishou.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/9-10:53
 * @Version:
 */
@Service
public class CalculateServiceImpl implements CalculateService {


    @Autowired
    CalculateRecordMapper calculateRecordMapper;

    @Autowired
    CalculateCardinalMapper calculateCardinalMapper;

    @Override
    public void recordResult(CalculateStepOneVO calculateStepOne) {
        CalculateRecord calculateRecord = calculateStepOne.toCalculateRecord();
        calculateRecord.setGenerateReport(CommonalityProperty.NO);
        calculateRecord.setCreateTime(new Date());
        calculateRecordMapper.insert(calculateRecord);
    }


    @Override
    public ResultBean calculate(CalculateStepOneVO calculateStepOne) {
        long startTime=System.currentTimeMillis();

        //保存测算记录
        recordResult(calculateStepOne);

        List<CalculateResultPO> calculateResults = new ArrayList<CalculateResultPO>();
        calculateStepOne.setUserId(null);
        List<CalculateCardinal> calculateCardinals = calculateCardinalMapper.selectAll();
        //年总收入
        Double annualTurnover = calculateAnnualTurnover(calculateCardinals, calculateStepOne.getClientNum());
        //客户类型占比
        CalculateResultPO customersNumber = calculateData(calculateCardinals, Double.valueOf(calculateStepOne.getClientNum()), CalculateType.CUSTOMERS_NUMBER, false);
        customersNumber=numberOfPeople(customersNumber);
        //各客户类型消费占比/年
        CalculateResultPO customersConsume = calculateData(calculateCardinals, annualTurnover, CalculateType.CUSTOMERS_CONSUME, false);
        //各客户类型平均消费占比/月
        CalculateResultPO customersConsumeMean = getCustomersConsumeMean(customersConsume);
        //各类客户人均充值
        CalculateResultPO perCapitaTopUp = getPerCapitaTopUp(customersConsume.getMap(),calculateCardinals,CalculateType.PER_CAPITA_TOP_UP);
        //各类客户卡余额与充值比例
        CalculateResultPO balanceTopUpRatio = getBalanceTopUpRatio(perCapitaTopUp.getMap(),calculateCardinals,CalculateType.BALANCE_TOP_UP_RATIO);

        //并行多线程处理
        ExecutorService exe = Executors.newCachedThreadPool();
        List<Future<CalculateResultPO>> results=new ArrayList<Future<CalculateResultPO>>();

        //各产出贡献值
        results.add(exe.submit(new calculateContributionThread(calculateStepOne,annualTurnover)));
        //全年经营业绩占比/年
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.PROJECT_PROPORTION,false)));
        //客户每月占比
        results.add(exe.submit(new calculateDataThread(calculateCardinals,Double.valueOf(calculateStepOne.getClientNum()),CalculateType.CUSTOMER_SHARE,false)));
        //常规项目占比/月
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.GENERAL_PROPORTION,false)));
        //大型项目占比/月
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.MAJOR_PROPORTION,false)));
        //居家项目占比/月
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.FURNITURE_PROPORTION,false)));
        //其他项目占比/月
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.OTHER_PROPORTION,false)));
        //顾客消费结构设计
        results.add(exe.submit(new calculateDataThread(calculateCardinals,annualTurnover,CalculateType.CONSUMPTION_STRUCTURE,false)));

        try {
            calculateResults.add(customersNumber);
            calculateResults.add(customersConsume);
            calculateResults.add(customersConsumeMean);
            calculateResults.add(perCapitaTopUp);
            calculateResults.add(balanceTopUpRatio);
            for (Future<CalculateResultPO> fs : results) {
                if (fs.isDone()) {
                    CalculateResultPO calculateResultPO = fs.get();
                    //对人数数据取整
                    if(calculateResultPO.getResultType() == new Long(CalculateType.CUSTOMER_SHARE.getType())){
                        calculateResultPO=numberOfPeople(calculateResultPO);
                    }
                    calculateResults.add(calculateResultPO);

                    if(calculateResultPO.getResultType() == new Long(CalculateType.CONSUMPTION_STRUCTURE.getType())){
                        //各客户/年非划卡消费占比
                        calculateResults.add(getAccountConsumption(calculateResultPO.getMap(),
                                CalculateType.NO_ACCOUNT_CONSUMPTION,
                                calculateCardinals,
                                CalculateRule.NO_ACCOUNT_CONSUMPTION));
                        //各客户/年划卡消费占比
                        calculateResults.add(getAccountConsumption(calculateResultPO.getMap(),
                                CalculateType.ACCOUNT_CONSUMPTION,
                                calculateCardinals,
                                CalculateRule.ACCOUNT_CONSUMPTION));
                    }
                }
            }
        }catch (Exception e) {
            return new ResultBean(ResultConstants.SYSTEM_EXCEPTION);
        }

        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");
        return new ResultBean<>(calculateResults);
    }

    /**
     * 测算各类型顾客均充卡额
     * @param customersConsumeMap 基数集
     * @param calculateCardinals 测算规则集
     * @param calculateType 测算类型
     * @return
     */
    private CalculateResultPO getPerCapitaTopUp(Map<String,Double> customersConsumeMap,List<CalculateCardinal> calculateCardinals,CalculateType calculateType){
        CalculateResultPO calculateResultPO = new CalculateResultPO(calculateType);
        Map perCapitaTopUpMap = calculateResultPO.getMap();
        List<CalculateCardinal> collect = calculateCardinals.stream().
                filter(calculateCardinal -> calculateCardinal.getType() == calculateType.getType())
                .collect(Collectors.toList());
        Double value;
        for(CalculateCardinal calculateCardinal:collect){
            switch (calculateCardinal.getName()){
                case "big_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.BIG_CUSTOMERS_CONSUME.getRetCode());
                    break;
                case "A_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.A_CUSTOMERS_CONSUME.getRetCode());
                    break;
                case "B_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.B_CUSTOMERS_CONSUME.getRetCode());
                    break;
                case "C_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.C_CUSTOMERS_CONSUME.getRetCode());
                    break;
                case "D_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.D_CUSTOMERS_CONSUME.getRetCode());
                    break;
                case "E_per_capita_top_up":
                    value=customersConsumeMap.get(CalculateRule.E_CUSTOMERS_CONSUME.getRetCode());
                    break;
                    default:
                        value=0.0;
            }
            perCapitaTopUpMap.put(calculateCardinal.getName(),value*calculateCardinal.getValue());
        }
        calculateResultPO.setMap(perCapitaTopUpMap);
        return calculateResultPO;
    }


    /**
     * 测算各类型顾客卡余额与充卡比例
     * @param customersConsumeMap 基数集
     * @param calculateCardinals 测算规则集
     * @param calculateType 测算类型
     * @return
     */
    private CalculateResultPO getBalanceTopUpRatio(Map<String,Double> customersConsumeMap,List<CalculateCardinal> calculateCardinals,CalculateType calculateType){
        CalculateResultPO calculateResultPO = new CalculateResultPO(calculateType);
        Map perCapitaTopUpMap = calculateResultPO.getMap();
        List<CalculateCardinal> collect = calculateCardinals.stream().
                filter(calculateCardinal -> calculateCardinal.getType() == calculateType.getType())
                .collect(Collectors.toList());
        Double value;
        for(CalculateCardinal calculateCardinal:collect){
            switch (calculateCardinal.getName()){
                case "big_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.BIG_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                case "A_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.A_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                case "B_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.B_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                case "C_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.C_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                case "D_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.D_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                case "E_balance__top_up_ratio":
                    value=customersConsumeMap.get(CalculateRule.E_PER_CAPITA_TOP_UP.getRetCode());
                    break;
                default:
                    value=0.0;
            }
            perCapitaTopUpMap.put(calculateCardinal.getName(),value*calculateCardinal.getValue());
        }
        calculateResultPO.setMap(perCapitaTopUpMap);
        return calculateResultPO;
    }

    /**
     * 以指定测算数据为基值测算
     * @param map 数据集
     * @param calculateRule 数据基值Key
     * @param calculateType 测算规则类型
     * @param calculateCardinals 测算规则集
     * @return
     */
    private CalculateResultPO  getAccountConsumption(Map<String,Double> map,
                                                           CalculateType calculateType,
                                                           List<CalculateCardinal> calculateCardinals,
                                                           CalculateRule calculateRule){
        Double basicValue = map.get(calculateRule.getRetCode());
        return calculateData(calculateCardinals,basicValue,calculateType,false);
    }

    /**
     * 只入不舍 取整
     * @param calculateResultPO
     * @return
     */
    private CalculateResultPO numberOfPeople(CalculateResultPO calculateResultPO){
        Map<String,Double> map = calculateResultPO.getMap();
        map.forEach((K,V)->{
            if(!CommonUtils.isIntegerForDouble(V)){
                V=V-V%1+1;
                map.put(K,V);
            }
        });
        calculateResultPO.setMap(map);
        return calculateResultPO;
    }

    /**
     * 获取各类客户平均消费占比
     * @param calculateResultPO
     * @return
     */
    private CalculateResultPO getCustomersConsumeMean(CalculateResultPO calculateResultPO){
        CalculateResultPO customersConsumeMean = new CalculateResultPO(CalculateType.CUSTOMERS_CONSUME_MEAN);
        calculateResultPO.getMap().forEach((K,V)->{
            customersConsumeMean.getMap().put(K,V/CommonalityProperty.month);
        });
        return customersConsumeMean;
    }

    /**
     * 测算贡献值
     */
    class calculateContributionThread implements Callable<CalculateResultPO> {
        private CalculateStepOneVO calculateStepOne;
        private Double annualTurnover;
        public calculateContributionThread(CalculateStepOneVO calculateStepOne, Double annualTurnover){
            this.calculateStepOne=calculateStepOne;
            this.annualTurnover=annualTurnover;
        }
        @Override
        public CalculateResultPO call(){
            CalculateResultPO calculateResultPO = calculateContribution(calculateStepOne, annualTurnover);
            return calculateResultPO;
        }
    }


    /**
     * 根据规则测算
     */
    class calculateDataThread implements Callable<CalculateResultPO>{

        private List<CalculateCardinal> calculateCardinals;//测算规则
        private Double annualTurnover;//年总收入
        private CalculateType calculateType;//测算类型
        private boolean month;//是否按月统计

        public calculateDataThread(List<CalculateCardinal> calculateCardinals,Double annualTurnover,CalculateType calculateType,boolean month){
            this.calculateCardinals=calculateCardinals;
            this.annualTurnover=annualTurnover;
            this.calculateType=calculateType;
            this.month=month;
        }
        @Override
        public CalculateResultPO call(){
            return calculateData(calculateCardinals,annualTurnover,calculateType,month);
        }
    }




    /**
     * 计算年营业总收入
     * @param calculateCardinals
     * @param customerNumber 月客户数
     * @return
     */
    private Double calculateAnnualTurnover(List<CalculateCardinal> calculateCardinals, Long customerNumber){
        Double value = calculateCardinals.stream()
                .filter(calculateCardinal -> calculateCardinal.getType() == CalculateType.CUSTOMER_CONTRIBUTIONS.getType())
                .findFirst()
                .get()
                .getValue();
        return customerNumber*value*CommonalityProperty.month;
    }


    /**
     * 计算各个贡献值
     * @param calculateStepOne
     * @param annualTurnover
     * @return
     */
    private CalculateResultPO calculateContribution(CalculateStepOneVO calculateStepOne, Double annualTurnover){
        CalculateResultPO calculateResultPO = new CalculateResultPO(CalculateType.PERFORMANCE_CONTRIBUTION_RATE);

        //反射机制获取对象所有属性名称
        Class calculateStepOneClass = calculateStepOne.getClass();
        Field[] declaredFields = calculateStepOneClass.getDeclaredFields();

        try {
            //遍历属性名称
            for(Field field:declaredFields){
                String name = field.getName();
                //过滤
                if(name.equals("serialVersionUid")){
                    continue;
                }
                //通过属性名称获取字段对象
                Field declaredField = calculateStepOneClass.getDeclaredField(name);
                declaredField.setAccessible(true);
                Object result = declaredField.get(calculateStepOne);
                if(result==null){
                    continue;
                }
                calculateResultPO.getMap().put(field.getName()+"Contribution",annualTurnover/Long.valueOf(String.valueOf(result)));
            }
        }catch (Exception e){
            return null;
        }
        return calculateResultPO;
    }


    /**
     * 根据不同类型计算各个月份的数据
     * @param calculateCardinals
     * @param basicValue 基值
     * @param month 结果是否/12个月
     * @return
     */
    private CalculateResultPO calculateData(List<CalculateCardinal> calculateCardinals,Double basicValue,CalculateType calculateType,boolean month){
        CalculateResultPO calculateResultPO=new CalculateResultPO(calculateType);
        List<CalculateCardinal> collect = calculateCardinals.stream()
                .filter(calculateCardinal -> calculateCardinal.getType() == calculateType.getType())
                .collect(Collectors.toList());
        if(month){
            for(CalculateCardinal calculateCardinal:collect){
                calculateResultPO.getMap().put(calculateCardinal.getName(),calculateCardinal.getValue()*basicValue/CommonalityProperty.month);
            }
        }else {
            for(CalculateCardinal calculateCardinal:collect){
                calculateResultPO.getMap().put(calculateCardinal.getName(),calculateCardinal.getValue()*basicValue);
            }
        }
        return calculateResultPO;
    }


}
