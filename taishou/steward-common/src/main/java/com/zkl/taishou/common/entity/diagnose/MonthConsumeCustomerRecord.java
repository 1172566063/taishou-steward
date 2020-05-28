/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客每月消耗业绩诊断记录 month_consume_customer_record
 * @author orange1438 code generator
 * date:2020-05-28 19:07:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MonthConsumeCustomerRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6006305955750552539L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 一月消耗金额
     */ 
    private Double january;

    /** 
     * 二月消耗金额
     */ 
    private Double february;

    /** 
     * 三月消耗金额
     */ 
    private Double march;

    /** 
     * 四月消耗金额
     */ 
    private Double april;

    /** 
     * 五月消耗金额
     */ 
    private Double may;

    /** 
     * 六月消耗金额
     */ 
    private Double june;

    /** 
     * 七月消耗金额
     */ 
    private Double july;

    /** 
     * 八月消耗金额
     */ 
    private Double august;

    /** 
     * 九月消耗金额
     */ 
    private Double september;

    /** 
     * 十月消耗金额
     */ 
    private Double october;

    /** 
     * 十一月消耗金额
     */ 
    private Double november;

    /** 
     * 十二月消耗金额
     */ 
    private Double december;

    /** 
     */ 
    private Date createTime;

    /** 
     * 结果
     */ 
    private Integer resultId;

}