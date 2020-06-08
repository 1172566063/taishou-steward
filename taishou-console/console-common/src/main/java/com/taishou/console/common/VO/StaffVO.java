/* https://github.com/orange1438 */
package com.taishou.console.common.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 
 * 员工表 staff
 * @author orange1438 code generator
 * date:2020-06-03 09:49:06
 */
@Data
@ApiModel("StaffVO")
@Accessors(chain = true)
public class StaffVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 1374326890113925180L;

    /** 
     */
    @ApiModelProperty("id")
    private Long id;

    /** 
     * 姓名
     */
    @ApiModelProperty("员工姓名")
    private String name;


    /** 
     * 1男0女  默认：1
     */
    @ApiModelProperty("1男0女")
    private Long sex;

}