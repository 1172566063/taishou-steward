/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客年度服务卡余额诊断记录 customer_card_balance_record
 * @author orange1438 code generator
 * date:2020-05-28 17:56:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerCardBalanceRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -7021963377131911491L;

    /** 
     */ 
    private Integer id;

    /** 
     * 用户id
     */ 
    private Integer userId;

    /** 
     * 大型顾客购卡人数
     */ 
    private Integer bigCardBalanceNum;

    /** 
     * A类顾客卡余人数
     */ 
    private Integer aCardBalanceNum;

    /** 
     * B类顾客卡余人数
     */ 
    private Integer bCardBalanceNum;

    /** 
     * C类顾客卡余人数
     */ 
    private Integer cCardBalanceNum;

    /** 
     * D类顾客卡余人数
     */ 
    private Integer dCardBalanceNum;

    /** 
     * E类顾客卡余人数
     */ 
    private Integer eCardBalanceNum;

    /** 
     * 大型顾客卡余总额
     */ 
    private Double bigCardBalanceLimit;

    /** 
     * A类顾客卡余总额
     */ 
    private Double aCardBalanceLimit;

    /** 
     * B类顾客卡余总额
     */ 
    private Double bCardBalanceLimit;

    /** 
     * C类顾客卡余总额
     */ 
    private Double cCardBalanceLimit;

    /** 
     * D类顾客卡余总额
     */ 
    private Double dCardBalanceLimit;

    /** 
     * E类顾客卡余总额
     */ 
    private Double eCardBalanceLimit;

    /** 
     * 结果
     */ 
    private Integer resultId;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;

}