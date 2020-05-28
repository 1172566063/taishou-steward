/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zkl.taishou.common.entity.diagnose.YearCashFlowRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 
 * 年现金流诊断 year_cashflow_record
 * @author orange1438 code generator
 * date:2020-05-22 14:20:35
 */
@Data
@Accessors(chain = true)
@ApiModel("YearCashFlowRecordVO")
public class YearCashFlowRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = -2621148276580782439L;

    /**
     */
    @JsonIgnore
    private Integer userId;

    /**
     * 销售成交人数
     */
    @ApiModelProperty("销售成交人数")
    private Integer npMarket;

    /**
     * 还款人数成交人数
     */
    @ApiModelProperty("还款人数成交人数")
    private Integer npRefund;

    /**
     * 充值增加人数
     */
    @ApiModelProperty("充值增加人数")
    private Integer npTopUpIncrease;

    /**
     * 充值减少人数
     */
    @ApiModelProperty("充值减少人数")
    private Integer npTopUpReduce;

    /**
     * 定金增加人数
     */
    @ApiModelProperty("定金增加人数")
    private Integer npOrderIncrease;

    /**
     * 定金较少人数
     */
    @ApiModelProperty("定金较少人数")
    private Integer npOrderReduce;

    /**
     * 销售成交现金总额
     */
    @ApiModelProperty("销售成交现金总额")
    private Double moneyMarket;

    /**
     * 还款现金总额
     */
    @ApiModelProperty("还款现金总额")
    private Double moneyRefund;

    /**
     * 充值增加
     */
    @ApiModelProperty("充值增加")
    private Double moneyTopUpIncrease;

    /**
     * 充值减少
     */
    @ApiModelProperty("充值减少")
    private Double moneyTopUpReduce;

    /**
     * 定金增加
     */
    @ApiModelProperty("定金增加")
    private Double moneyOrderIncrease;

    /**
     * 定金减少
     */
    @ApiModelProperty("定金减少")
    private Double moneyOrderReduce;


    public YearCashFlowRecord toYearCashFlowRecord(){
        YearCashFlowRecord yearCashFlowRecord = new YearCashFlowRecord()
                .setMoneyMarket(moneyMarket)
                .setMoneyOrderIncrease(moneyOrderIncrease)
                .setMoneyOrderReduce(moneyOrderReduce)
                .setMoneyRefund(moneyRefund)
                .setMoneyTopUpIncrease(moneyTopUpIncrease)
                .setMoneyTopUpReduce(moneyTopUpReduce)
                .setNpMarket(npMarket)
                .setNpOrderIncrease(npOrderIncrease)
                .setNpOrderReduce(npOrderReduce)
                .setNpRefund(npRefund)
                .setNpTopUpIncrease(npTopUpIncrease)
                .setNpTopUpReduce(npTopUpReduce);
        return yearCashFlowRecord;
    }

}