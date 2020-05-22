/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客来源诊断记录表 customer_source_record
 * @author orange1438 code generator
 * date:2020-05-22 18:00:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerSourceRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -734067244713058299L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer userId;

    /** 
     * 线下拓展
     */ 
    private Integer offline;

    /** 
     * 微信
     */ 
    private Integer wechat;

    /** 
     * 线上拓展
     */ 
    private Integer online;

    /** 
     * 自己进店
     */ 
    private Integer oneself;

    /** 
     * 异业联盟
     */ 
    private Integer otherIndustries;

    /** 
     * 老客推荐
     */ 
    private Integer customersRecommend;

    /** 
     * 其他
     */ 
    private Integer other;

    /** 
     */ 
    private Date createTime;

    /** 
     */ 
    private Integer resultId;


}