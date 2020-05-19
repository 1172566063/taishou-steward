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
    CUSTOMER_SHARE("客户占比/月",3),//月度业绩分布
    MAJOR_PROPORTION("大型项目占比/月",4),
    GENERAL_PROPORTION("常规项目占比/月",5),
    FURNITURE_PROPORTION("居家项目占比/月",6),
    OTHER_PROPORTION("其他项目占比/月",7),
    CUSTOMERS_CONSUME("客户消费占比/年",8),//客户消费类型设计
    CUSTOMERS_NUMBER("客户类型人数占比/月",9),//客户结构设计
    PERFORMANCE_CONTRIBUTION_RATE("业绩贡献率",10),//业绩贡献率
    CONSUMPTION_STRUCTURE("顾客消费结构设计",11),//顾客消费结构设计
    ACCOUNT_CONSUMPTION("各类客户账户划卡消费占比",12),//各类顾客消费结构设计
    NO_ACCOUNT_CONSUMPTION("各类客户非账户划卡消费占比",13),//各类顾客消费结构设计
    PER_CAPITA_TOP_UP("各类客户人均充值",14),//人均充卡额设计
    BALANCE_TOP_UP_RATIO("各类客户卡余额与充值比例",15),//卡余额设计
    CUSTOMERS_CONSUME_MEAN("各类客户平均消费占比/月",99),
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
