/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 
 * 员工表 staff
 * @author orange1438 code generator
 * date:2020-06-03 09:49:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Staff implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 1374326890113925180L;

    /** 
     */ 
    private Long id;

    /** 
     * 姓名
     */ 
    private String name;

    /** 
     * 年龄
     */
    private Long age;

    /** 
     * 1男0女  默认：1
     */ 
    private Long sex;

    /** 
     * 所属店铺
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Integer storeId;

    /** 
     * 时候删除 Y删除  默认：N
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String del;

}