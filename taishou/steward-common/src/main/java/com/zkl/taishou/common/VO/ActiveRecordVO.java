/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zkl.taishou.common.entity.diagnose.ActiveRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客活跃度诊断记录表 active_record
 * @author orange1438 code generator
 * date:2020-05-22 14:47:10
 */
@Data
@Accessors(chain = true)
@ApiModel("ActiveRecordVO")
public class ActiveRecordVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7953636660413722004L;

    /** 
     */
    @JsonIgnore
    private Integer userId;

    /** 
     * 每月新增客人
     */
    @ApiModelProperty(value = "每月新增客人")
    private Integer newCustomers;

    /** 
     * 每月活跃客人
     */
    @ApiModelProperty(value = "每月活跃客人")
    private Integer activeCustomers;

    /** 
     * 一般的客人
     */
    @ApiModelProperty(value = "一般的客人")
    private Integer generalCustomers;

    /** 
     * 潜水的客人
     */
    @ApiModelProperty(value = "潜水的客人")
    private Integer potentialCustomers;

    /** 
     * 流失的客人
     */
    @ApiModelProperty(value = "流失的客人")
    private Integer loseCustomers;


    public ActiveRecord toActiveRecord(){
        ActiveRecord activeRecord = new ActiveRecord()
                .setActiveCustomers(activeCustomers)
                .setGeneralCustomers(generalCustomers)
                .setLoseCustomers(loseCustomers)
                .setNewCustomers(newCustomers)
                .setPotentialCustomers(potentialCustomers);
        return activeRecord;
    }
}