/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/** 店铺信息表
 * @author orange1438 code generator
 * date:2020-06-03 09:49:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Store implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -3869618836829099232L;

    /** 
     */ 
    private Long id;

    /** 
     * 店铺名称
     */
    @ApiModelProperty("店铺名称")
    private String name;

    /** 
     * 所在地
     */
    @ApiModelProperty("所在地")
    private String address;

    /** 
     * 所属用户
     */
    @JsonIgnore
    private Long userId;

    /** 
     * 是否逻辑删除 Y删除  默认：N
     */
    @JsonIgnore
    private String del;

    /**
     * 员工
     */
    @ApiModelProperty(value = "员工列表",hidden = true)
    private List<Staff> staffs;
}