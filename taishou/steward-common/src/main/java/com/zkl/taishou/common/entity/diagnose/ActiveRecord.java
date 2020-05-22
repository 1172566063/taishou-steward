/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ActiveRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7953636660413722004L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 每月新增客人
     */ 
    private Integer newCustomers;

    /** 
     * 每月活跃客人
     */ 
    private Integer activeCustomers;

    /** 
     * 一般的客人
     */ 
    private Integer generalCustomers;

    /** 
     * 潜水的客人
     */ 
    private Integer potentialCustomers;

    /** 
     * 流失的客人
     */ 
    private Integer loseCustomers;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;

    /** 
     * 结果id
     */ 
    private Integer resultId;


}