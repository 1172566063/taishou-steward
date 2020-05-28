package com.zkl.taishou.common.constants;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/12-18:16
 * @Version:
 */
public enum  CalculateRule {
    CUSTOMER_CONTRIBUTIONS("customer_contributions","客户贡献基值"),
    MAJOR_PROJECT_PROPORTION("major_project_proportion","大项目业绩占比 %值"),
    GENERAL_PROJECT_PROPORTION("general_project_proportion","常规项目业绩占比 %值"),
    FURNITURE_PROJECT_PROPORTION("furniture_project_proportion","家居项目金额 %值"),
    OTHER_PROJECT_PROPORTION("other_project_proportion","其他类（含光电类、纹绣类）%值"),
    MAJOR_PERFORMANCE_HANDWORK_REPORT("major_performance_handwork_report","月度消耗（含手工）分布"),
    JANUARY_CUSTOMER_SHARE("january_customer_share","一月份客户占比 %值"),
    FEBRUARY_CUSTOMER_SHARE("february_customer_share","二月份客户占比 %值"),
    MARCH_CUSTOMER_SHARE("march_customer_share","三月份客户占比 %值"),
    APRIL_CUSTOMER_SHARE("april_customer_share","四月份客户占比 %值"),
    MAY_CUSTOMER_SHARE("may_customer_share","五月份客户占比 %值"),
    JUNE_CUSTOMER_SHARE("june_customer_share","六月份客户占比 %值"),
    JULY_CUSTOMER_SHARE("july_customer_share","七月份客户占比 %值"),
    AUGUST_CUSTOMER_SHARE("august_customer_share","八月份客户占比 %值"),
    SEPTEMBER_CUSTOMER_SHARE("september_customer_share","九月份客户占比 %值"),
    OCTOBER_CUSTOMER_SHARE("october_customer_share","十月份客户占比 %值"),
    NOVEMBER_CUSTOMER_SHARE("november_customer_share","十一月份客户占比 %值"),
    DECEMBER_CUSTOMER_SHARE("december_customer_share","十二月份客户占比 %值"),
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
    BIG_CUSTOMERS_CONSUME("big_customers_consume","大客户消费占比"),
    A_CUSTOMERS_CONSUME("A_customers_consume","A客户消费占比"),
    B_CUSTOMERS_CONSUME("B_customers_consume","B客户消费占比"),
    C_CUSTOMERS_CONSUME("C_customers_consume","C客户消费占比"),
    D_CUSTOMERS_CONSUME("D_customers_consume","D客户消费占比"),
    E_CUSTOMERS_CONSUME("E_customers_consume","E客户消费占比"),
    BIG_CUSTOMERS_NUMBER("big_customers_number","大客户类型人数占比"),
    A_CUSTOMERS_NUMBER("A_customers_number","A客户类型人数占比"),
    B_CUSTOMERS_NUMBER("B_customers_number","B客户类型人数占比"),
    C_CUSTOMERS_NUMBER("C_customers_number","C客户类型人数占比"),
    D_CUSTOMERS_NUMBER("D_customers_number","D客户类型人数占比"),
    E_CUSTOMERS_NUMBER("E_customers_number","E客户类型人数占比"),
    BIG_AVERAGE_CUSTOMER("big_average_customer","大客户类型人均消费"),
    A_AVERAGE_CUSTOMER("A_average_customer","A客户类型人均消费"),
    B_AVERAGE_CUSTOMER("B_average_customer","B客户类型人均消费"),
    C_AVERAGE_CUSTOMER("C_average_customer","C客户类型人均消费"),
    D_AVERAGE_CUSTOMER("D_average_customer","D客户类型人均消费"),
    E_AVERAGE_CUSTOMER("E_average_customer","E客户类型人均消费"),
    ;

    /**
     * 结果值
     */
    private String name;

    /**
     * 结果信息
     */
    private String explain;

    CalculateRule(String name, String explain) {
        this.name = name;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setRetCode(Integer retCode) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setRetMsg(String explain) {
        this.explain = explain;
    }
}
