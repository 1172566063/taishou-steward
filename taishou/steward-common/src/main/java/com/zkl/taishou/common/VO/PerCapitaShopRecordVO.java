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
 * 人均到店次数诊断记录表 per_capita_shop_record
 * @author orange1438 code generator
 * date:2020-05-22 19:07:34
 */
@Data
@Accessors(chain = true)
@ApiModel("PerCapitaShopRecordVO")
public class PerCapitaShopRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 1965015124387985318L;

    /**
     */
    private Integer userId;

    /**
     * 大客月到店次数
     */
    private Integer monthBigCustomer;

    /**
     * A类顾客月到店次数
     */
    private Integer monthACustomer;

    /**
     * B类顾客月到店次数
     */
    private Integer monthBCustomer;

    /**
     * C类顾客月到店次数
     */
    private Integer monthCCustomer;

    /**
     * D类顾客月到店次数
     */
    private Integer monthDCustomer;

    /**
     * E类顾客月到店次数
     */
    private Integer monthECustomer;

    /**
     * 月耗卡不消费
     */
    private Integer monthDonConsume;

    /**
     * 大客年到店次数
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
     * 年耗卡不消费
     */
    private Integer yearDonConsume;


}