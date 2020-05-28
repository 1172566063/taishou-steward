package com.zkl.taishou.common.constants;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/13-10:00
 * @Version:
 */
public enum  CalculateType {

        CUSTOMER_CONTRIBUTIONS("单客户月贡献基值",1),//测算基本数据
        PROJECT_PROPORTION("全年经营业绩占比/年",2),//全年经营业绩测算
        CUSTOMER_SHARE("到店客流月度分析",3),//到店客流月度分析
        MAJOR_PERFORMANCE_REPORT("月度现金中业绩分布",4),
        MAJOR_PERFORMANCE_HANDWORK_REPORT("月度消耗（含手工）分布",5),
        YEAR_TO_THE_STORE_CUSTOMER("全年到店客户数",6),
        TRIMESTER_TO_THE_STORE_CUSTOMER("全年有效客户数（3个月内到店）",7),
        CUSTOMERS_CONSUME("客户消费类型设计",8),//客户消费类型设计
        CUSTOMERS_NUMBER("客户结构设计",9),//客户结构设计
        PERFORMANCE_CONTRIBUTION_RATE("业绩贡献率",10),//业绩贡献率
        AVERAGE_CUSTOMER_SPENDING("客户类型平均消费设计",11),
        FOUNDATION_PROJECT_CONTRIBUTION("基础项目贡献率",12),
        CUSTOMER_SHARE_SWELL("到店客流月度分析扩大倍数",13),
    ;
    /**
     * 结果值
     */
    private String name;

    /**
     * 结果信息
     */
    private Integer type;

    CalculateType(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(Integer retCode) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
