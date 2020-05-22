/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客年龄结构诊断记录表 age_group_record
 * @author orange1438 code generator
 * date:2020-05-22 16:41:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AgeGroupRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 564321939664327290L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 十九岁以下
     */
    private Integer lessthanNineteen;

    /**
     * 二十岁-二十四
     */
    private Integer twentyTwentyfour;

    /**
     * 二十五-二十九
     */
    private Integer twentyfiveTwentynine;

    /**
     * 三十-三四十
     */
    private Integer thirtyThirtyfour;

    /**
     * 三十五-三十九
     */
    private Integer thirtyfiveThirtynine;

    /**
     * 四十-四十四
     */
    private Integer fortyFortyfour;

    /**
     * 四十五-四十九
     */
    private Integer fortyfiveFortynine;

    /**
     * 五十-五十四
     */
    private Integer fiftyFiftyfour;

    /**
     * 五十五岁以上
     */
    private Integer greaterthanFiftyfive;
}