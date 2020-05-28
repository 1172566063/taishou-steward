/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客消费潜力诊断 consumer_spending_potential
 * @author orange1438 code generator
 * date:2020-05-28 15:28:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ConsumerSpendingPotential implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6934741981586772487L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     */ 
    private Date createTime;

    /** 
     */ 
    private Integer resultId;

    /** 
     * 大客最高单次消费
     */ 
    private Double bigCustomerHighConsumption;

    /** 
     * A客最高单次消费
     */ 
    private Double aCustomerHighConsumption;

    /** 
     * B客最高单次消费
     */ 
    private Double bCustomerHighConsumption;

    /** 
     * C客最高单次消费
     */ 
    private Double cCustomerHighConsumption;

    /** 
     * D客最高单次消费
     */ 
    private Double dCustomerHighConsumption;

    /** 
     * E客最高单次消费
     */ 
    private Double eCustomerHighConsumption;

}