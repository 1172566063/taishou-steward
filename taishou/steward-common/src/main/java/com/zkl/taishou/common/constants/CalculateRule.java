package com.zkl.taishou.common.constants;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/12-18:16
 * @Version:
 */
public enum  CalculateRule {
    CUSTOMER_CONTRIBUTIONS("客户贡献基值","customer_contributions"),
    MAJOR_PROJECT_PROPORTION("大项目业绩占比 %值","major_project_proportion"),
    GENERAL_PROJECT_PROPORTION("常规项目业绩占比 %值","general_project_proportion"),
    FURNITURE_PROJECT_PROPORTION("家居项目金额 %值","furniture_project_proportion"),
    OTHER_PROJECT_PROPORTION("其他类（含光电类、纹绣类）%值","other_project_proportion"),
    MAJOR_PERFORMANCE_HANDWORK_REPORT("月度消耗（含手工）分布","major_performance_handwork_report"),
    JANUARY_CUSTOMER_SHARE("一月份客户占比 %值","january_customer_share"),
    FEBRUARY_CUSTOMER_SHARE("二月份客户占比 %值","february_customer_share"),
    MARCH_CUSTOMER_SHARE("三月份客户占比 %值","march_customer_share"),
    APRIL_CUSTOMER_SHARE("四月份客户占比 %值","april_customer_share"),
    MAY_CUSTOMER_SHARE("五月份客户占比 %值","may_customer_share"),
    JUNE_CUSTOMER_SHARE("六月份客户占比 %值","june_customer_share"),
    JULY_CUSTOMER_SHARE("七月份客户占比 %值","july_customer_share"),
    AUGUST_CUSTOMER_SHARE("八月份客户占比 %值","august_customer_share"),
    SEPTEMBER_CUSTOMER_SHARE("九月份客户占比 %值","september_customer_share"),
    OCTOBER_CUSTOMER_SHARE("十月份客户占比 %值","october_customer_share"),
    NOVEMBER_CUSTOMER_SHARE("十一月份客户占比 %值","november_customer_share"),
    DECEMBER_CUSTOMER_SHARE("十二月份客户占比 %值","december_customer_share"),
    /*JANUARY_GENERAL_PROPORTION("january_performance_report","一月份常规项目占比 %值"),
    FEBRUARY_GENERAL_PROPORTION("february_general_proportion","二月份常规项目占比 %值"),
    MARCH_GENERAL_PROPORTION("march_general_proportion","三月份常规项目占比 %值"),
    APRIL_GENERAL_PROPORTION("april_general_proportion","四月份常规项目占比 %值"),
    MAY_GENERAL_PROPORTION("may_general_proportion","五月份常规项目占比 %值"),
    JUNE_GENERAL_PROPORTION("june_general_proportion","六月份常规项目占比 %值"),
    JULY_GENERAL_PROPORTION("july_general_proportion","七月份常规项目占比 %值"),
    AUGUST_GENERAL_PROPORTION("august_general_proportion","八月份常规项目占比 %值"),
    SEPTEMBER_GENERAL_PROPORTION("september_general_proportion","九月份常规项目占比 %值"),
    OCTOBER_GENERAL_PROPORTION("october_general_proportion","十月份常规项目占比 %值"),
    NOVEMBER_GENERAL_PROPORTION("november_general_proportion","十一月份常规项目占比 %值"),
    DECEMBER_GENERAL_PROPORTION("december_general_proportion","十二月份常规项目占比 %值"),*/
    BIG_CUSTOMERS_CONSUME("大客户消费占比","big_customers_consume"),
    A_CUSTOMERS_CONSUME("A客户消费占比","A_customers_consume"),
    B_CUSTOMERS_CONSUME("B客户消费占比","B_customers_consume"),
    C_CUSTOMERS_CONSUME("C客户消费占比","C_customers_consume"),
    D_CUSTOMERS_CONSUME("D客户消费占比","D_customers_consume"),
    E_CUSTOMERS_CONSUME("E客户消费占比","E_customers_consume"),
    BIG_CUSTOMERS_NUMBER("大客户类型人数占比","big_customers_number"),
    A_CUSTOMERS_NUMBER("A客户类型人数占比","A_customers_number"),
    B_CUSTOMERS_NUMBER("B客户类型人数占比","B_customers_number"),
    C_CUSTOMERS_NUMBER("C客户类型人数占比","C_customers_number"),
    D_CUSTOMERS_NUMBER("D客户类型人数占比","D_customers_number"),
    E_CUSTOMERS_NUMBER("E客户类型人数占比","E_customers_number"),
    BIG_AVERAGE_CUSTOMER("大客户类型人均消费","big_average_customer"),
    A_AVERAGE_CUSTOMER("A客户类型人均消费","A_average_customer"),
    B_AVERAGE_CUSTOMER("B客户类型人均消费","B_average_customer"),
    C_AVERAGE_CUSTOMER("C客户类型人均消费","C_average_customer"),
    D_AVERAGE_CUSTOMER("D客户类型人均消费","D_average_customer"),
    E_AVERAGE_CUSTOMER("E客户类型人均消费","E_average_customer"),
    ;

    /**
     * 结果值
     */
    private String value;

    /**
     * 结果信息
     */
    private String explain;

    CalculateRule( String explain,String name) {
        this.value = name;
        this.explain = explain;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExplain() {
        return explain;
    }

    public void setRetMsg(String explain) {
        this.explain = explain;
    }
}
