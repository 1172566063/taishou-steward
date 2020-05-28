/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客年度服务卡耗诊断 year_consumption_card_record
 * @author orange1438 code generator
 * date:2020-05-28 17:14:55
 */
@Data
@ApiModel("YearConsumptionCardRecordVO")
@Accessors(chain = true)
public class YearConsumptionCardRecordVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2936194387880836273L;

    /** 
     */
    @JsonIgnore
    private Integer userId;

    /** 
     * 大客年年到店次数
     */
    @ApiModelProperty("大客年年到店次数")
    private Integer yearBigCustomer;

    /** 
     * A类顾客年到店次数
     */
    @ApiModelProperty("A类顾客年到店次数")
    private Integer yearACustomer;

    /** 
     * B类顾客年到店次数
     */
    @ApiModelProperty("B类顾客年到店次数")
    private Integer yearBCustomer;

    /** 
     * C类顾客年到店次数
     */
    @ApiModelProperty("C类顾客年到店次数")
    private Integer yearCCustomer;

    /** 
     * D类顾客年到店次数
     */
    @ApiModelProperty("D类顾客年到店次数")
    private Integer yearDCustomer;

    /** 
     * E类顾客年到店次数
     */
    @ApiModelProperty("E类顾客年到店次数")
    private Integer yearECustomer;

    /** 
     * 大客年耗卡总额
     */
    @ApiModelProperty("大客年耗卡总额")
    private Integer bigCustomerConsumptionCard;

    /** 
     * A类顾客耗卡总额
     */
    @ApiModelProperty("A类顾客耗卡总额")
    private Integer aCustomerConsumptionCard;

    /** 
     * B类顾客耗卡总额
     */
    @ApiModelProperty("B类顾客耗卡总额")
    private Integer bCustomerConsumptionCard;

    /** 
     * C类顾客耗卡总额
     */
    @ApiModelProperty("C类顾客耗卡总额")
    private Integer cCustomerConsumptionCard;

    /** 
     * D类顾客耗卡总额
     */
    @ApiModelProperty("D类顾客耗卡总额")
    private Integer dCustomerConsumptionCard;

    /** 
     * E类顾客耗卡总额
     */
    @ApiModelProperty("E类顾客耗卡总额")
    private Integer eCustomerConsumptionCard;


}