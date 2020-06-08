/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/** 用户表
 * @author orange1438 code generator
 * date:2020-06-02 17:43:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6375499091225282825L;

    /** 
     */ 
    private Long id;

    /** 
     * 名字
     */ 
    private String name;

    /** 
     * 性别 0女 1男  默认：1
     */ 
    private Long sex;

    /** 
     * 年龄
     */ 
    private Long age;

    /** 
     * 角色  默认：1
     */ 
    private Long roleId;

    /** 
     * 微信凭证
     */ 
    private String wxUnionid;

    /** 
     * 手机号
     */ 
    private String phone;

    /** 
     * 密码
     */ 
    private String password;

    /** 
     * 头像地址
     */ 
    private String headPortraitImg;

}