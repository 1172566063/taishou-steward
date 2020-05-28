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
 * 顾客全年消耗业绩诊断记录 customer_year_performance
 * @author orange1438 code generator
 * date:2020-05-28 18:55:20
 */
@Data
@ApiModel("CustomerYearPerformanceVO")
@Accessors(chain = true)
public class CustomerYearPerformanceVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 2366832935003625310L;

    /**
     */
    @JsonIgnore
    private Integer userId;


    /**
     * 大项目成交人数
     */
    @ApiModelProperty("大项目成交人数")
    private Integer numberOfBigProjects;

    /**
     * 常规单次成交人数
     */
    @ApiModelProperty("常规单次成交人数")
    private Integer numberOfRegularTransactions;

    /**
     * 产品成交人数
     */
    @ApiModelProperty("产品成交人数")
    private Integer numberOfProductTransactions;

    /**
     * 服务卡成交人数
     */
    @ApiModelProperty("服务卡成交人数")
    private Integer numberOfCardTransactions;

    /**
     * 大项目消耗金额
     */
    @ApiModelProperty("大项目消耗金额")
    private Double bigConsumptionAmount;

    /**
     * 常规单次成交金额
     */
    @ApiModelProperty("常规单次成交金额")
    private Double regularConsumptionAmount;

    /**
     * 产品成交金额
     */
    @ApiModelProperty("产品成交金额")
    private Double productConsumptionAmount;

    /**
     * 服务卡成交金额
     */
    @ApiModelProperty("服务卡成交金额")
    private Double cardConsumptionAmount;


}