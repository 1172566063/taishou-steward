/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客职业诊断记录表 customers_professional_record
 * @author orange1438 code generator
 * date:2020-05-22 18:47:00
 */
@Data
@Accessors(chain = true)
@ApiModel("CustomersProfessionalRecordVO")
public class CustomersProfessionalRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 4198533565159441067L;


    /**
     */
    private Integer userId;

    /**
     * 公务员
     */
    private Integer civilServants;

    /**
     * 国企事业单位
     */
    private Integer businessUnit;

    /**
     * 企业老板
     */
    private Integer businessOwner;

    /**
     * 企业白领
     */
    private Integer wcw;

    /**
     * 家庭主妇
     */
    private Integer aHousewife;

    /**
     * 学生
     */
    private Integer students;

    /**
     * 其他
     */
    private Integer other;


}