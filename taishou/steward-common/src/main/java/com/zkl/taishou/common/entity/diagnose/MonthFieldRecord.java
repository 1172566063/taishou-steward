/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客每月实操客数诊断记录表 month_field_record
 * @author orange1438 code generator
 * date:2020-05-28 19:14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MonthFieldRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2393733303561265058L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 一月实操客数
     */ 
    private Integer numberFieldJanuary;

    /** 
     * 二月实操客数
     */ 
    private Integer numberFieldFebruary;

    /** 
     * 三月实操客数
     */ 
    private Integer numberFieldMarch;

    /** 
     * 四月实操客数
     */ 
    private Integer numberFieldApril;

    /** 
     * 五月实操客数
     */ 
    private Integer numberFieldMay;

    /** 
     * 六月实操客数
     */ 
    private Integer numberFieldJune;

    /** 
     * 七月实操客数
     */ 
    private Integer numberFieldJuly;

    /** 
     * 八月实操客数
     */ 
    private Integer numberFieldAugust;

    /** 
     * 九月实操客数
     */ 
    private Integer numberFieldSeptember;

    /** 
     * 十月实操客数
     */ 
    private Integer numberFieldOctober;

    /** 
     * 十一月实操客数
     */ 
    private Integer numberFieldNovember;

    /** 
     * 十二月实操客数
     */ 
    private Integer numberFieldDecember;

    /** 
     * 一月实操金额
     */ 
    private Double moneyFieldJanuary;

    /** 
     * 二月实操金额
     */ 
    private Double moneyFieldFebruary;

    /** 
     * 三月实操金额
     */ 
    private Double moneyFieldMarch;

    /** 
     * 四月实操金额
     */ 
    private Double moneyFieldApril;

    /** 
     * 五月实操金额
     */ 
    private Double moneyFieldMay;

    /** 
     * 六月实操金额
     */ 
    private Double moneyFieldJune;

    /** 
     * 七月实操金额
     */ 
    private Double moneyFieldJuly;

    /** 
     * 八月实操金额
     */ 
    private Double moneyFieldAugust;

    /** 
     * 九月实操金额
     */ 
    private Double moneyFieldSeptember;

    /** 
     * 十月实操金额
     */ 
    private Double moneyFieldOctober;

    /** 
     * 十一月实操金额
     */ 
    private Double moneyFieldNovember;

    /** 
     * 十二月实操金额
     */ 
    private Double moneyFieldDecember;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;

    /** 
     * 诊断结果
     */ 
    private Integer resultId;

}