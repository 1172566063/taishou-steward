/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Staff implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5310725164411092633L;

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
    private Long storeId;

    /** 
     * 时候删除 Y删除  默认：N
     */ 
    private String del;

}