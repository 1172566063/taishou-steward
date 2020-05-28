package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.PO.CalculateResultPO;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.common.constants.*;
import com.zkl.taishou.common.entity.calculate.CalculateCardinal;
import com.zkl.taishou.common.entity.calculate.CalculateRecord;
import com.zkl.taishou.common.utils.CommonUtils;
import com.zkl.taishou.dao.calculate.CalculateCardinalDAO;
import com.zkl.taishou.dao.calculate.CalculateRecordDAO;
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
    CalculateRecordDAO calculateRecordMapper;

    @Autowired
    CalculateCardinalDAO calculateCardinalMapper;

    @Override
    public void recordResult(CalculateStepOneVO calculateStepOne) {
        CalculateRecord calculateRecord = calculateStepOne.toCalculateRecord();
        calculateRecord.setGenerateReport(CommonalityProperty.NO);
        calculateRecord.setCreateTime(new Date());
        calculateRecordMapper.insert(calculateRecord);
    }


    /**
     * 功能描述：测算
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/25 13:16
     */
    @Override
    public ResultBean calculate(CalculateStepOneVO calculateStepOne) {
        //保存测算记录
        recordResult(calculateStepOne);

        List<CalculateResultPO> calculateResults = new ArrayList<CalculateResultPO>();
        calculateStepOne.setUserId(null);
        List<CalculateCardinal> calculateCardinals = calculateCardinalMapper.selectAll();
        //年总收入
        Double annualTurnover = calculateAnnualTurnover(calculateCardinals, calculateStepOne.getClientNum());
        //客户结构设计
        CalculateResultPO customersNumber = customersNumber(calculateStepOne, calculateCardinals);

        //客户消费类型设计
        CalculateResultPO customersConsume = getCustomersNumber(customersNumber, calculateCardinals);

        //客户平均消费类型设计
        CalculateResultPO averageCustomerSpending = getAverageCustomerSpending(customersNumber, customersConsume);

        //并行多线程处理
        ExecutorService exe = Executors.newCachedThreadPool();
        List<Future<CalculateResultPO>> results = new ArrayList<Future<CalculateResultPO>>();

        //到店客流月度
        results.add(exe.submit(new CustomerShareSwellThread(calculateStepOne, calculateCardinals, CalculateType.CUSTOMER_SHARE)));
        //业绩贡献率
        results.add(exe.submit(new CalculateContributionThread(calculateStepOne, annualTurnover)));
        //全年经营业绩占比
        results.add(exe.submit(new CalculateDataThread(calculateCardinals, annualTurnover, CalculateType.PROJECT_PROPORTION, false)));
        //月度现金总业绩分布
        results.add(exe.submit(new CalculateDataThread(calculateCardinals, annualTurnover, CalculateType.MAJOR_PERFORMANCE_REPORT, false)));

        calculateResults.add(customersNumber);
        calculateResults.add(customersConsume);
        calculateResults.add(averageCustomerSpending);
        for (Future<CalculateResultPO> fs : results) {
            try {
                //if (fs.isDone()) {
                    CalculateResultPO calculateResultPO = fs.get();
                    calculateResults.add(calculateResultPO);
                    //基础项目贡献率
                    if (calculateResultPO.getResultType().equals(new Long(CalculateType.PROJECT_PROPORTION.getType()))) {
                        calculateResultPO = foundationProjectContribution(calculateResultPO, calculateStepOne);
                        calculateResults.add(calculateResultPO);
                    }
                    //月度消耗（含手工）分布
                    if (calculateResultPO.getResultType() .equals(new Long(CalculateType.MAJOR_PERFORMANCE_REPORT.getType()))) {
                        calculateResultPO = monthlyConsumptionHandwork(calculateCardinals, calculateResultPO);
                        calculateResults.add(calculateResultPO);
                    }
                //}
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

        }
        return new ResultBean<>(calculateResults);
    }

    /**
     * 功能描述：客户结构设计
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/25 11:27
     */
    private CalculateResultPO customersNumber(CalculateStepOneVO calculateStepOneVO, List<CalculateCardinal> calculateCardinals) {
        List<CalculateCardinal> yearToTheStoreCustomerRule = getRule(calculateCardinals, CalculateType.YEAR_TO_THE_STORE_CUSTOMER);
        List<CalculateCardinal> customersNumberRule = getRule(calculateCardinals, CalculateType.CUSTOMERS_NUMBER);
        Long clientNum = calculateStepOneVO.getClientNum();
        Double yearToTheStoreCustomer = clientNum * yearToTheStoreCustomerRule.get(0).getValue();
        return numberOfPeople(calculateData(customersNumberRule, yearToTheStoreCustomer, CalculateType.CUSTOMERS_NUMBER, false));
    }


    /**
     * 功能描述：月消耗手工分布
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/25 9:53
     */
    private CalculateResultPO monthlyConsumptionHandwork(List<CalculateCardinal> calculateCardinals, CalculateResultPO calculateResultPO) {
        CalculateResultPO result = new CalculateResultPO(CalculateType.MAJOR_PERFORMANCE_HANDWORK_REPORT);
        List<CalculateCardinal> rule = getRule(calculateCardinals, CalculateType.MAJOR_PERFORMANCE_HANDWORK_REPORT);
        CalculateCardinal calculateCardinal = rule.get(0);
        Map<String, Double> map = calculateResultPO.getMap();
        map.forEach((k, y) -> {
            map.put(k, y * calculateCardinal.getValue());
        });
        result.setMap(map);
        return result;
    }


    /**
     * 功能描述：基础项目贡献率
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/23 16:51
     */
    private CalculateResultPO foundationProjectContribution(CalculateResultPO projectProportion, CalculateStepOneVO calculateStepOneVO) {
        Map<String, Double> map = projectProportion.getMap();
        CalculateResultPO calculateResultPO = new CalculateResultPO(CalculateType.FOUNDATION_PROJECT_CONTRIBUTION);
        Map<String, Double> resultMap = calculateResultPO.getMap();
        Double general = map.get(CalculateRule.GENERAL_PROJECT_PROPORTION.getName());
        Double furniture = map.get(CalculateRule.FURNITURE_PROJECT_PROPORTION.getName());
        Double other = map.get(CalculateRule.OTHER_PROJECT_PROPORTION.getName());
        Double sum = general + furniture + other;
        resultMap.put("areaOutPut", sum / calculateStepOneVO.getArea() / CommonalityProperty.month);
        resultMap.put("roomOutPut", sum / calculateStepOneVO.getRoomNum() / CommonalityProperty.month);
        resultMap.put("bedOutPut", sum / calculateStepOneVO.getBedNum() / CommonalityProperty.month);
        resultMap.put("staffOutPut", sum / calculateStepOneVO.getStaffNum() / CommonalityProperty.month);
        resultMap.put("clientOutPut", sum / calculateStepOneVO.getClientNum() / CommonalityProperty.month);
        calculateResultPO.setMap(resultMap);
        return calculateResultPO;
    }


    /**
     * 客户类型平均消费设计
     *
     * @param customersNumber  客户结构设计
     * @param customersConsume 客户消费类型设计
     * @return
     */
    private CalculateResultPO getAverageCustomerSpending(CalculateResultPO customersNumber, CalculateResultPO customersConsume) {
        CalculateResultPO calculateResultPO = new CalculateResultPO(CalculateType.AVERAGE_CUSTOMER_SPENDING);
        Map<String, Double> resultMap = calculateResultPO.getMap();
        Map<String, Double> customersNumberMap = customersNumber.getMap();
        Map<String, Double> customersConsumeMap = customersConsume.getMap();
        Set<Map.Entry<String, Double>> entries = customersConsumeMap.entrySet();
        for (Map.Entry<String, Double> data : entries) {
            String K = data.getKey();
            Double value = data.getValue();
            switch (K) {
                case "big_customers_consume":
                    resultMap.put(CalculateRule.BIG_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.BIG_CUSTOMERS_NUMBER.getName()));
                    break;
                case "A_customers_consume":
                    resultMap.put(CalculateRule.A_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.A_CUSTOMERS_NUMBER.getName()));
                    break;
                case "B_customers_consume":
                    resultMap.put(CalculateRule.B_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.B_CUSTOMERS_NUMBER.getName()));
                    break;
                case "C_customers_consume":
                    resultMap.put(CalculateRule.C_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.C_CUSTOMERS_NUMBER.getName()));
                    break;
                case "D_customers_consume":
                    resultMap.put(CalculateRule.D_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.D_CUSTOMERS_NUMBER.getName()));
                    break;
                case "E_customers_consume":
                    resultMap.put(CalculateRule.E_AVERAGE_CUSTOMER.getName(), value / customersNumberMap.get(CalculateRule.E_CUSTOMERS_NUMBER.getName()));
                    break;
            }
            calculateResultPO.setMap(resultMap);
        }
        return calculateResultPO;
    }


    /**
     * 客户消费类型设计
     *
     * @param calculateResultPO  基数集
     * @param calculateCardinals 测算规则集
     * @return
     */
    private CalculateResultPO getCustomersNumber(CalculateResultPO calculateResultPO, List<CalculateCardinal> calculateCardinals) {
        CalculateResultPO customersNumber = new CalculateResultPO(CalculateType.CUSTOMERS_CONSUME);
        Map<String, Double> resultMap = customersNumber.getMap();
        Map<String, Double> customersConsumeMap = calculateResultPO.getMap();
        List<CalculateCardinal> collect = getRule(calculateCardinals, CalculateType.CUSTOMERS_CONSUME);
        Double value;
        for (CalculateCardinal calculateCardinal : collect) {
            switch (calculateCardinal.getName()) {
                case "big_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.BIG_CUSTOMERS_NUMBER.getName());
                    break;
                case "A_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.A_CUSTOMERS_NUMBER.getName());
                    break;
                case "B_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.B_CUSTOMERS_NUMBER.getName());
                    break;
                case "C_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.C_CUSTOMERS_NUMBER.getName());
                    break;
                case "D_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.D_CUSTOMERS_NUMBER.getName());
                    break;
                case "E_customers_consume":
                    value = customersConsumeMap.get(CalculateRule.E_CUSTOMERS_NUMBER.getName());
                    break;
                default:
                    value = 0.0;
            }
            resultMap.put(calculateCardinal.getName(), value * calculateCardinal.getValue());
        }
        customersNumber.setMap(resultMap);
        return customersNumber;
    }


    /**
     * 只入不舍 取整
     *
     * @param calculateResultPO
     * @return
     */
    private CalculateResultPO numberOfPeople(CalculateResultPO calculateResultPO) {
        Map<String, Double> map = calculateResultPO.getMap();
        map.forEach((K, V) -> {
            if (!CommonUtils.isIntegerForDouble(V)) {
                V = V - V % 1 + 1;
                map.put(K, V);
            }
        });
        calculateResultPO.setMap(map);
        return calculateResultPO;
    }


    /**
     * 测算贡献值
     */
    class CalculateContributionThread implements Callable<CalculateResultPO> {
        private CalculateStepOneVO calculateStepOne;
        private Double annualTurnover;

        public CalculateContributionThread(CalculateStepOneVO calculateStepOne, Double annualTurnover) {
            this.calculateStepOne = calculateStepOne;
            this.annualTurnover = annualTurnover;
        }

        @Override
        public CalculateResultPO call() {
            CalculateResultPO calculateResultPO = calculateContribution(calculateStepOne, annualTurnover);
            return calculateResultPO;
        }
    }


    /**
     * 根据规则测算
     */
    class CalculateDataThread implements Callable<CalculateResultPO> {

        private List<CalculateCardinal> calculateCardinals;//测算规则
        private Double annualTurnover;//年总收入
        private CalculateType calculateType;//测算类型
        private boolean month;//是否按月统计

        public CalculateDataThread(List<CalculateCardinal> calculateCardinals, Double annualTurnover, CalculateType calculateType, boolean month) {
            this.calculateCardinals = calculateCardinals;
            this.annualTurnover = annualTurnover;
            this.calculateType = calculateType;
            this.month = month;
        }

        @Override
        public CalculateResultPO call() {
            return calculateData(calculateCardinals, annualTurnover, calculateType, month);
        }
    }

    /**
     * 根据规则测算
     */
    class CustomerShareSwellThread implements Callable<CalculateResultPO> {
        private List<CalculateCardinal> calculateCardinals;//测算规则
        private CalculateType calculateType;//测算类型
        private CalculateStepOneVO calculateStepOneVO;

        public CustomerShareSwellThread(CalculateStepOneVO calculateStepOneVO, List<CalculateCardinal> calculateCardinals, CalculateType calculateType) {
            this.calculateCardinals = calculateCardinals;
            this.calculateType = calculateType;
            this.calculateStepOneVO = calculateStepOneVO;
        }

        @Override
        public CalculateResultPO call() {
            Double value = getRule(calculateCardinals, CalculateType.CUSTOMER_SHARE_SWELL).get(0).getValue();
            Double baseValue = calculateStepOneVO.getStaffNum() * value * CommonalityProperty.month;
            return numberOfPeople(calculateData(calculateCardinals, baseValue, calculateType, false));
        }
    }

    /**
     * 计算年营业总收入
     *
     * @param calculateCardinals
     * @param customerNumber     月客户数
     * @return
     */
    private Double calculateAnnualTurnover(List<CalculateCardinal> calculateCardinals, Long customerNumber) {
        Double value = calculateCardinals.stream()
                .filter(calculateCardinal -> calculateCardinal.getType() == CalculateType.CUSTOMER_CONTRIBUTIONS.getType())
                .findFirst()
                .get()
                .getValue();
        return customerNumber * value * CommonalityProperty.month;
    }


    /**
     * 计算各个贡献值
     *
     * @param calculateStepOne
     * @param annualTurnover
     * @return
     */
    private CalculateResultPO calculateContribution(CalculateStepOneVO calculateStepOne, Double annualTurnover) {
        CalculateResultPO calculateResultPO = new CalculateResultPO(CalculateType.PERFORMANCE_CONTRIBUTION_RATE);

        //反射机制获取对象所有属性名称
        Class calculateStepOneClass = calculateStepOne.getClass();
        Field[] declaredFields = calculateStepOneClass.getDeclaredFields();

        try {
            //遍历属性名称
            for (Field field : declaredFields) {
                String name = field.getName();
                //过滤
                if (name.equals("serialVersionUID")) {
                    continue;
                }
                //通过属性名称获取字段对象
                Field declaredField = calculateStepOneClass.getDeclaredField(name);
                declaredField.setAccessible(true);
                Object result = declaredField.get(calculateStepOne);
                if (result == null) {
                    continue;
                }
                Double contribute = annualTurnover / Long.valueOf(String.valueOf(result));
                calculateResultPO.getMap().put(field.getName() + "Contribution", contribute);
            }
        } catch (Exception e) {
            return null;
        }
        return calculateResultPO;
    }

    private List<CalculateCardinal> getRule(List<CalculateCardinal> calculateCardinals, CalculateType calculateType) {
        return calculateCardinals.stream()
                .filter(calculateCardinal -> calculateCardinal.getType() == calculateType.getType())
                .collect(Collectors.toList());
    }

    /**
     * 根据不同类型计算各个月份的数据
     *
     * @param calculateCardinals
     * @param basicValue         基值
     * @param month              结果是否/12个月
     * @return
     */
    private CalculateResultPO calculateData(List<CalculateCardinal> calculateCardinals, Double basicValue, CalculateType calculateType, boolean month) {
        CalculateResultPO calculateResultPO = new CalculateResultPO(calculateType);
        List<CalculateCardinal> collect = getRule(calculateCardinals, calculateType);
        if (month) {
            for (CalculateCardinal calculateCardinal : collect) {
                calculateResultPO.getMap().put(calculateCardinal.getName(), calculateCardinal.getValue() * basicValue / CommonalityProperty.month);
            }
        } else {
            for (CalculateCardinal calculateCardinal : collect) {
                calculateResultPO.getMap().put(calculateCardinal.getName(), calculateCardinal.getValue() * basicValue);
            }
        }
        return calculateResultPO;
    }


}
