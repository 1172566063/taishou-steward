/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 年度服务卡消费诊断记录 customer_service_card_record
 * @author orange1438 code generator
 * date:2020-05-28 17:44:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerServiceCardRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -3267590057160923493L;

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
    private Integer bigPurchaseCardNum;

    /** 
     * A类顾客购卡人数
     */ 
    private Integer aPurchaseCardNum;

    /** 
     * B类顾客购卡人数
     */ 
    private Integer bPurchaseCardNum;

    /** 
     * C类顾客购卡人数
     */ 
    private Integer cPurchaseCardNum;

    /** 
     * D类顾客购卡人数
     */ 
    private Integer dPurchaseCardNum;

    /** 
     * E类顾客购卡人数
     */ 
    private Integer ePurchaseCardNum;

    /** 
     * 大型顾客购卡额
     */ 
    private Double bigPurchaseCardLimit;

    /** 
     * A类顾客购卡额
     */ 
    private Double aPurchaseCardLimit;

    /** 
     * B类顾客购卡额
     */ 
    private Double bPurchaseCardLimit;

    /** 
     * C类顾客购卡额
     */ 
    private Double cPurchaseCardLimit;

    /** 
     * D类顾客购卡额
     */ 
    private Double dPurchaseCardLimit;

    /** 
     * E类顾客购卡额
     */ 
    private Double ePurchaseCardLimit;

    /** 
     * 结果
     */ 
    private Integer resultId;

    /** 
     * 创建时间  默认：CURRENT_TIMESTAMP
     */ 
    private Date createTime;


}