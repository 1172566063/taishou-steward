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

/** 
 * 员工表 staff
 * @author orange1438 code generator
 * date:2020-05-29 09:30:53
 */
@Data
@ApiModel("StaffVO")
@Accessors(chain = true)
public class StaffVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5310725164411092633L;

    /** 
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;


}