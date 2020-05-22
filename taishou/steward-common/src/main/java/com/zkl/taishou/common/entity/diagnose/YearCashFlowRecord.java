/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 年现金流诊断 year_cashflow_record
 * @author orange1438 code generator
 * date:2020-05-22 14:20:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class YearCashFlowRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2621148276580782439L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 销售成交人数
     */ 
    private Integer npMarket;

    /** 
     * 还款人数成交人数
     */ 
    private Integer npRefund;

    /** 
     * 充值增加人数
     */ 
    private Integer npTopUpIncrease;

    /** 
     * 充值减少人数
     */ 
    private Integer npTopUpReduce;

    /** 
     * 定金增加人数
     */ 
    private Integer npOrderIncrease;

    /** 
     * 定金较少人数
     */ 
    private Integer npOrderReduce;

    /** 
     * 销售成交现金总额
     */ 
    private Double moneyMarket;

    /** 
     * 还款现金总额
     */ 
    private Double moneyRefund;

    /** 
     * 充值增加
     */ 
    private Double moneyTopUpIncrease;

    /** 
     * 充值 减少
     */ 
    private Double moneyTopUpReduce;

    /** 
     * 定金增加
     */ 
    private Double moneyOrderIncrease;

    /** 
     * 定金减少
     */ 
    private Double moneyOrderReduce;

    /** 
     * 结果
     */ 
    private Integer resultId;

    /** 
     */ 
    private Date createTime;


}