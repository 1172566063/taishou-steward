package com.zkl.taishou.common.constants;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/30-22:27
 * @Version:
 */
public enum  MethodNames {

    calculate("calculate","测算"),
    recordConsumptionAbility("recordConsumptionAbility","顾客年度产品消费诊断"),
    recordConsumerSpendingPotential("recordConsumerSpendingPotential","顾客消费潜力诊断"),
    recordConsumerYearSpending("recordConsumerYearSpending","顾客年度项目消费诊断"),
    recordCustomerServiceCard("recordCustomerServiceCard","年度服务卡消费诊断"),
    recordYearConsumptionCard("recordYearConsumptionCard","顾客年度服务卡耗诊断"),
    recordCustomerCardBalanceRecord("recordCustomerCardBalanceRecord","顾客年度服务卡余额诊断"),
    recordCustomerYearPerformance("recordCustomerYearPerformance","顾客全年消耗业绩诊断"),
    recordMonthConsumeCustomerRecord("recordMonthConsumeCustomerRecord","顾客每月消耗业绩诊断"),
    recordMonthField("recordMonthField","顾客每月实操客数诊断")
    ;


    /**
     * 结果值
     */
    private String value;

    /**
     * 结果信息
     */
    private String key;

    MethodNames( String key,String name) {
        this.value = name;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static String getValueByKey(String key){
        String value=null;
        for(MethodNames methodEnum:values()){
            if(methodEnum.getKey().trim().equals(key)){
                value=methodEnum.getValue();
            }
        }
        return value;
    }
}
