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
 * 客流量诊断记录 traffic_record
 * @author orange1438 code generator
 * date:2020-05-22 19:00:26
 */
@Data
@Accessors(chain = true)
@ApiModel("TrafficRecordVO")
public class TrafficRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = 666820005676961223L;


    /**
     */
    private Integer userId;

    /**
     * 到店顾客人数
     */
    private Integer toshopCustomerCount;

    /**
     * 到店消费人数
     */
    private Integer toshopCount;

    /**
     * 护理次数
     */
    private Integer nursingCount;

    /**
     * 员工劳动次数
     */
    private Integer employeesLaborCount;

    /**
     * 床位使用次数
     */
    private Integer bedsUseCount;


}