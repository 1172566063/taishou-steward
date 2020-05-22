/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 每月毛利润诊断记录表 profit_diagnosis_record
 * @author orange1438 code generator
 * date:2020-05-19 18:05:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProfitDiagnosisRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 908135058052824509L;

    /** 
     */ 
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 一月销售额
     */
    private Double salesJanuary;

    /**
     * 二月销售额
     */
    private Double salesFebruary;

    /**
     * 三月销售额
     */
    private Double salesMarch;

    /**
     * 四月销售额
     */
    private Double salesApril;

    /**
     * 五月销售额
     */
    private Double salesMay;

    /**
     * 六月销售额
     */
    private Double salesJune;

    /**
     * 七月销售额
     */
    private Double salesJuly;

    /**
     * 八月销售额
     */
    private Double salesAugust;

    /**
     * 九月销售额
     */
    private Double salesSeptember;

    /**
     * 十月销售额
     */
    private Double salesOctober;

    /**
     * 十一月销售额
     */
    private Double salesNovember;

    /**
     * 十二月销售额
     */
    private Double salesDecember;

    /**
     * 一月成本费用额
     */
    private Double costJanuary;

    /**
     * 二月成本费用额
     */
    private Double costFebruary;

    /**
     * 三月成本费用额
     */
    private Double costMarch;

    /**
     * 四月成本费用额
     */
    private Double costApril;

    /**
     * 五月成本费用额
     */
    private Double costMay;

    /**
     * 六月成本费用额
     */
    private Double costJune;

    /**
     * 七月成本费用额
     */
    private Double costJuly;

    /**
     * 八月成本费用额
     */
    private Double costAugust;

    /**
     * 九月成本费用额
     */
    private Double costSeptember;

    /**
     * 十月成本费用额
     */
    private Double costOctober;

    /**
     * 十一月成本费用额
     */
    private Double costNovember;

    /**
     * 十二月成本费用额
     */
    private Double costDecember;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;

    /** 
     * 诊断结果
     */ 
    private Integer resultId;


}