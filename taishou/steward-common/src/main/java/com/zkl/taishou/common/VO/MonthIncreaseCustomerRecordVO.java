/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 每月新增顾客诊断记录 month_increase_customer_record
 * @author orange1438 code generator
 * date:2020-05-22 19:15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MonthIncreaseCustomerRecordVO implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -8146142060650204260L;

    /**
     */
    private Integer userId;

    /**
     * 一月新增顾客
     */
    private Integer january;

    /**
     * 二月新增顾客
     */
    private Integer february;

    /**
     * 三月新增顾客
     */
    private Integer march;

    /**
     * 四月新增顾客
     */
    private Integer april;

    /**
     * 五月新增顾客
     */
    private Integer may;

    /**
     * 六月新增顾客
     */
    private Integer june;

    /**
     * 七月新增顾客
     */
    private Integer july;

    /**
     * 八月新增顾客
     */
    private Integer august;

    /**
     * 九月新增顾客
     */
    private Integer september;

    /**
     * 十月新增顾客
     */
    private Integer october;

    /**
     * 十一月新增顾客
     */
    private Integer november;

    /**
     * 十二月新增顾客
     */
    private Integer december;

}