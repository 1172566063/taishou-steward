/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 
 * @author orange1438 code generator
 * date:2020-05-29 14:25:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Store implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 3581742250840495709L;

    /** 
     */ 
    private Integer id;

    /** 
     * 店铺名称
     */ 
    private String name;

    /** 
     * 所在地
     */ 
    private String address;

    /** 
     * 所属用户
     */ 
    private Integer userId;

    /** 
     * 是否逻辑删除 Y删除  默认：N
     */ 
    private String del;


}