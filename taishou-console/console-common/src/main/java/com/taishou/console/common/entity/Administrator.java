/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 后台管理员 administrator
 * @author orange1438 code generator
 * date:2020-06-06 15:56:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Administrator implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -8965375343037747555L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Date createTime;

    /** 
     * 用户名称
     */ 
    private String name;

    /** 
     * 用户名
     */ 
    private String root;

    /** 
     * 密码
     */ 
    private String password;

    /** 
     * 角色  默认：0
     */ 
    private Long roleId;

    /** 
     * 是否删除 Y删除  默认：N
     */ 
    private String del;

}