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
 * 年度服务卡消费诊断记录 customer_service_card_record
 * @author orange1438 code generator
 * date:2020-05-28 17:44:15
 */
@Data
@ApiModel("CustomerServiceCardRecordVO")
@Accessors(chain = true)
public class CustomerServiceCardRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = -3267590057160923493L;

    /**
     * 用户id
     */
    @JsonIgnore
    private Integer userId;

    /**
     * 大型顾客购卡人数
     */
    @ApiModelProperty("大型顾客购卡人数")
    private Integer bigPurchaseCardNum;

    /**
     * A类顾客购卡人数
     */
    @ApiModelProperty("A类顾客购卡人数")
    private Integer aPurchaseCardNum;

    /**
     * B类顾客购卡人数
     */
    @ApiModelProperty("B类顾客购卡人数")
    private Integer bPurchaseCardNum;

    /**
     * C类顾客购卡人数
     */
    @ApiModelProperty("C类顾客购卡人数")
    private Integer cPurchaseCardNum;

    /**
     * D类顾客购卡人数
     */
    @ApiModelProperty("D类顾客购卡人数")
    private Integer dPurchaseCardNum;

    /**
     * E类顾客购卡人数
     */
    @ApiModelProperty("E类顾客购卡人数")
    private Integer ePurchaseCardNum;

    /**
     * 大型顾客购卡额
     */
    @ApiModelProperty("大型顾客购卡额")
    private Double bigPurchaseCardLimit;

    /**
     * A类顾客购卡额
     */
    @ApiModelProperty("A类顾客购卡额")
    private Double aPurchaseCardLimit;

    /**
     * B类顾客购卡额
     */
    @ApiModelProperty("B类顾客购卡额")
    private Double bPurchaseCardLimit;

    /**
     * C类顾客购卡额
     */
    @ApiModelProperty("C类顾客购卡额")
    private Double cPurchaseCardLimit;

    /**
     * D类顾客购卡额
     */
    @ApiModelProperty("D类顾客购卡额")
    private Double dPurchaseCardLimit;

    /**
     * E类顾客购卡额
     */
    @ApiModelProperty("E类顾客购卡额")
    private Double ePurchaseCardLimit;


}