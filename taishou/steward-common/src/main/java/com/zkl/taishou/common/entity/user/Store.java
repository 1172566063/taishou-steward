/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 
 * @author orange1438 code generator
 * date:2020-05-22 19:44:11
 */
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Store implements Serializable {

    public Store(Long userId){
        this.userId=userId;
    }

    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -7901716313693208596L;

    /** 
     */ 
    private Long id;

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
    private Long userId;

    /** 
     * 是否逻辑删除 Y删除  默认：N
     */ 
    private String del;

}