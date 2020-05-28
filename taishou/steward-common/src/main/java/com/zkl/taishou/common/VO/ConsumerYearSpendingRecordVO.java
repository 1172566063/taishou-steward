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
 * 顾客年度项目消费诊断 consumer_year_spending_record
 * @author orange1438 code generator
 * date:2020-05-28 16:00:47
 */
@Data
@Accessors(chain = true)
@ApiModel("ConsumerYearSpendingRecordVO")
public class ConsumerYearSpendingRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 2752555988843110151L;

    /**
     */
    @JsonIgnore
    private Integer userId;

    /**
     * 基础品项大客年度消费总额
     */
    @ApiModelProperty(value = "基础品项大客年度消费总额")
    private Double basicsBigYearConsume;

    /**
     * 基础品项A客年度消费总额
     */
    @ApiModelProperty(value = "基础品项A客年度消费总额")
    private Double basicsAYearConsume;

    /**
     * 基础品项B客年度消费总额
     */
    @ApiModelProperty(value = "基础品项B客年度消费总额")
    private Double basicsBYearConsume;

    /**
     * 基础品项C客年度消费总额
     */
    @ApiModelProperty(value = "基础品项C客年度消费总额")
    private Double basicsCYearConsume;

    /**
     * 基础品项D客年度消费总额
     */
    @ApiModelProperty(value = "基础品项D客年度消费总额")
    private Double basicsDYearConsume;

    /**
     * 基础品项E客年度消费总额
     */
    @ApiModelProperty(value = "基础品项E客年度消费总额")
    private Double basicsEYearConsume;

    /**
     * 特色品项大客年度消费总额
     */
    @ApiModelProperty(value = "特色品项大客年度消费总额")
    private Double featureBigYearConsume;

    /**
     * 特色品项A客年度消费总额
     */
    @ApiModelProperty(value = "特色品项A客年度消费总额")
    private Double featureAYearConsume;

    /**
     * 特色品项B客年度消费总额
     */
    @ApiModelProperty(value = "特色品项B客年度消费总额")
    private Double featureBYearConsume;

    /**
     * 特色品项C客年度消费总额
     */
    @ApiModelProperty(value = "特色品项C客年度消费总额")
    private Double featureCYearConsume;

    /**
     * 特色品项D客年度消费总额
     */
    @ApiModelProperty(value = "特色品项D客年度消费总额")
    private Double featureDYearConsume;

    /**
     * 特色品项E客年度消费总额
     */
    @ApiModelProperty(value = "特色品项E客年度消费总额")
    private Double featureEYearConsume;

    /**
     * 大项目大客年度消费总额
     */
    @ApiModelProperty(value = "大项目大客年度消费总额")
    private Double mianBigYearConsume;

    /**
     * 大项目A客年度消费总额
     */
    @ApiModelProperty(value = "大项目A客年度消费总额")
    private Double mianAYearConsume;

    /**
     * 大项目B客年度消费总额
     */
    @ApiModelProperty(value = "大项目B客年度消费总额")
    private Double mianBYearConsume;

    /**
     * 大项目C客年度消费总额
     */
    @ApiModelProperty(value = "大项目C客年度消费总额")
    private Double mianCYearConsume;

    /**
     * 大项目D客年度消费总额
     */
    @ApiModelProperty(value = "大项目D客年度消费总额")
    private Double mianDYearConsume;

    /**
     * 大项目E客年度消费总额
     */
    @ApiModelProperty(value = "大项目E客年度消费总额")
    private Double mianEYearConsume;

    /**
     * 家居项目大客年度消费总额
     */
    @ApiModelProperty(value = "家居项目大客年度消费总额")
    private Double furnitureBigYearConsume;

    /**
     * 家居项目A客年度消费总额
     */
    @ApiModelProperty(value = "家居项目A客年度消费总额")
    private Double furnitureAYearConsume;

    /**
     * 家居项目B客年度消费总额
     */
    @ApiModelProperty(value = "家居项目B客年度消费总额")
    private Double furnitureBYearConsume;

    /**
     * 家居项目C客年度消费总额
     */
    @ApiModelProperty(value = "家居项目C客年度消费总额")
    private Double furnitureCYearConsume;

    /**
     * 家居项目D客年度消费总额
     */
    @ApiModelProperty(value = "家居项目D客年度消费总额")
    private Double furnitureDYearConsume;

    /**
     * 家居项目E客年度消费总额
     */
    @ApiModelProperty(value = "家居项目E客年度消费总额")
    private Double furnitureEYearConsume;


}