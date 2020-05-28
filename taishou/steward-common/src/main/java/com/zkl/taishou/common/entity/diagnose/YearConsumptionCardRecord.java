/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客年度服务卡耗诊断 year_consumption_card_record
 * @author orange1438 code generator
 * date:2020-05-28 17:14:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class YearConsumptionCardRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2936194387880836273L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 大客年年到店次数
     */ 
    private Integer yearBigCustomer;

    /** 
     * A类顾客年到店次数
     */ 
    private Integer yearACustomer;

    /** 
     * B类顾客年到店次数
     */ 
    private Integer yearBCustomer;

    /** 
     * C类顾客年到店次数
     */ 
    private Integer yearCCustomer;

    /** 
     * D类顾客年到店次数
     */ 
    private Integer yearDCustomer;

    /** 
     * E类顾客年到店次数
     */ 
    private Integer yearECustomer;

    /** 
     * 大客年耗卡总额
     */ 
    private Integer bigCustomerConsumptionCard;

    /** 
     * A类顾客耗卡总额
     */ 
    private Integer aCustomerConsumptionCard;

    /** 
     * B类顾客耗卡总额
     */ 
    private Integer bCustomerConsumptionCard;

    /** 
     * C类顾客耗卡总额
     */ 
    private Integer cCustomerConsumptionCard;

    /** 
     * D类顾客耗卡总额
     */ 
    private Integer dCustomerConsumptionCard;

    /** 
     * E类顾客耗卡总额
     */ 
    private Integer eCustomerConsumptionCard;

    /** 
     */ 
    private Date createTime;

    /** 
     * 结果
     */ 
    private Integer resultId;


}