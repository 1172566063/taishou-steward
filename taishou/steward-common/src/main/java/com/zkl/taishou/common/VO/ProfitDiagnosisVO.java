/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.entity.ProfitDiagnosisRecord;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.jar.JarEntry;

/** 
 * 每月毛利润诊断记录表 profit_diagnosis_record
 * @author orange1438 code generator
 * date:2020-05-19 18:05:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProfitDiagnosisVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 908135058052824508L;

    /**
     * 用户id
     */
    private Integer userId;

    /** 
     * 一月销售额
     */
    @ApiModelProperty(value = "一月销售额",required = true,example = "0")
    private Double salesJanuary;

    /** 
     * 二月销售额
     */
    @ApiModelProperty(value = "二月销售额",required = true,example = "0")
    private Double salesFebruary;

    /** 
     * 三月销售额
     */
    @ApiModelProperty(value = "三月销售额",required = true,example = "0")
    private Double salesMarch;

    /** 
     * 四月销售额
     */
    @ApiModelProperty(value = "四月销售额",required = true,example = "0")
    private Double salesApril;

    /** 
     * 五月销售额
     */
    @ApiModelProperty(value = "五月销售额",required = true,example = "0")
    private Double salesMay;

    /** 
     * 六月销售额
     */
    @ApiModelProperty(value = "六月销售额",required = true,example = "0")
    private Double salesJune;

    /** 
     * 七月销售额
     */
    @ApiModelProperty(value = "七月销售额",required = true,example = "0")
    private Double salesJuly;

    /** 
     * 八月销售额
     */
    @ApiModelProperty(value = "八月销售额",required = true,example = "0")
    private Double salesAugust;

    /** 
     * 九月销售额
     */
    @ApiModelProperty(value = "九月销售额",required = true,example = "0")
    private Double salesSeptember;

    /** 
     * 十月销售额
     */
    @ApiModelProperty(value = "十月销售额",required = true,example = "0")
    private Double salesOctober;

    /** 
     * 十一月销售额
     */
    @ApiModelProperty(value = "十一月销售额",required = true,example = "0")
    private Double salesNovember;

    /** 
     * 十二月销售额
     */
    @ApiModelProperty(value = "十二月销售额",required = true,example = "0")
    private Double salesDecember;

    /** 
     * 一月成本费用额
     */
    @ApiModelProperty(value = "一月成本费用额",required = true,example = "0")
    private Double costJanuary;

    /** 
     * 二月成本费用额
     */
    @ApiModelProperty(value = "二月成本费用额",required = true,example = "0")
    private Double costFebruary;

    /** 
     * 三月成本费用额
     */
    @ApiModelProperty(value = "三月成本费用额",required = true,example = "0")
    private Double costMarch;

    /** 
     * 四月成本费用额
     */
    @ApiModelProperty(value = "四月成本费用额",required = true,example = "0")
    private Double costApril;

    /** 
     * 五月成本费用额
     */
    @ApiModelProperty(value = "五月成本费用额",required = true,example = "0")
    private Double costMay;

    /** 
     * 六月成本费用额
     */
    @ApiModelProperty(value = "六月成本费用额",required = true,example = "0")
    private Double costJune;

    /** 
     * 七月成本费用额
     */
    @ApiModelProperty(value = "七月成本费用额",required = true,example = "0")
    private Double costJuly;

    /** 
     * 八月成本费用额
     */
    @ApiModelProperty(value = "八月成本费用额",required = true,example = "0")
    private Double costAugust;

    /** 
     * 九月成本费用额
     */
    @ApiModelProperty(value = "九月成本费用额",required = true,example = "0")
    private Double costSeptember;

    /** 
     * 十月成本费用额
     */
    @ApiModelProperty(value = "十月成本费用额",required = true,example = "0")
    private Double costOctober;

    /** 
     * 十一月成本费用额
     */
    @ApiModelProperty(value = "十一月成本费用额",required = true,example = "0")
    private Double costNovember;

    /** 
     * 十二月成本费用额
     */
    @ApiModelProperty(value = "十二月成本费用额",required = true,example = "0")
    private Double costDecember;

    public ProfitDiagnosisRecord toProfitDiagnosisRecord(){
        ProfitDiagnosisRecord profitDiagnosisRecord = new ProfitDiagnosisRecord()
                .setCostApril(costApril)
                .setCostAugust(costAugust)
                .setCostDecember(costDecember)
                .setCostFebruary(costFebruary)
                .setCostJanuary(costJanuary)
                .setCostJuly(costJuly)
                .setCostJune(costJune)
                .setCostMarch(costMarch)
                .setCostMay(costMay)
                .setCostNovember(costNovember)
                .setCostOctober(costOctober)
                .setCostSeptember(costSeptember)
                .setSalesApril(salesApril)
                .setSalesAugust(salesAugust)
                .setSalesDecember(salesDecember)
                .setSalesFebruary(salesFebruary)
                .setSalesJanuary(salesJanuary)
                .setSalesJuly(salesJuly)
                .setSalesJune(salesJune)
                .setSalesMarch(salesMarch)
                .setSalesMay(salesMay)
                .setSalesNovember(salesNovember)
                .setSalesOctober(salesOctober)
                .setSalesSeptember(salesSeptember);

        return profitDiagnosisRecord;
    }
}