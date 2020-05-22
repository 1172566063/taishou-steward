/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 现金流诊断记录表 cash_flow_record
 * @author orange1438 code generator
 * date:2020-05-22 10:21:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CashFlowRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 4979128577224053736L;

    /** 
     */ 
    private Long id;

    /** 
     * 用户id
     */ 
    private Long userId;

    /** 
     * 一月现金流
     */ 
    private Double moneyJanuary;

    /** 
     * 二月现金流
     */ 
    private Double moneyFebruary;

    /** 
     * 三月现金流
     */ 
    private Double moneyMarch;

    /** 
     * 四月现金流
     */ 
    private Double moneyApril;

    /** 
     * 五月现金流
     */ 
    private Double moneyMay;

    /** 
     * 六月现金流
     */ 
    private Double moneyJune;

    /** 
     * 七月现金流
     */ 
    private Double moneyJuly;

    /** 
     * 八月现金流
     */ 
    private Double moneyAugust;

    /** 
     * 九月现金流
     */ 
    private Double moneySeptember;

    /** 
     * 十月现金流
     */ 
    private Double moneyOctober;

    /** 
     * 十一月现金流
     */ 
    private Double moneyNovember;

    /** 
     * 十二月现金流
     */ 
    private Double moneyDecember;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;

    /** 
     * 结果
     */ 
    private Integer resultId;


}