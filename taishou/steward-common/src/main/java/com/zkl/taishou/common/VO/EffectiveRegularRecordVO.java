/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 有效顾客粘性诊断记录 effective_regular_record
 * @author orange1438 code generator
 * date:2020-05-22 19:15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EffectiveRegularRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 6640161929790982566L;

    /**
     */
    private Integer userId;

    /**
     * 每月到店顾客数
     */
    private Integer one;

    /**
     * 每2个月到店顾客数
     */
    private Integer two;

    /**
     * 每三个月到店顾客数
     */
    private Integer three;

    /**
     * 每六个月到店顾客数
     */
    private Integer six;

    /**
     * 每十二个月到店顾客数
     */
    private Integer twelve;

    /**
     * 每十二个月以上到店一次到店顾客数
     */
    private Integer exceedTwelve;


}