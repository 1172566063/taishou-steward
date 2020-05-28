/* https://github.com/orange1438 */
package com.zkl.taishou.common.VO;

import com.zkl.taishou.common.entity.diagnose.ConsumptionAbilityRecord;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/** 
 * 顾客消费能力诊断记录 consumption_ability_record
 * @author orange1438 code generator
 * date:2020-05-22 15:28:57
 */
@Data
@Accessors(chain = true)
@ApiModel("ConsumptionAbilityRecordVO")
public class ConsumptionAbilityRecordVO implements Serializable {
    /**
     * 串行版本ID
    */
    private static final long serialVersionUID = -4496215251174270319L;


    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 大型顾客人数
     */
    private Integer bigCount;

    /**
     * A类顾客人数
     */
    private Integer aCount;

    /**
     * B类顾客人数
     */
    private Integer bCount;

    /**
     * C类顾客人数
     */
    private Integer cCount;

    /**
     * D类顾客人数
     */
    private Integer dCount;

    /**
     * E类顾客人数
     */
    private Integer eCount;

    /**
     * 无消费能力顾客人数
     */
    private Integer zeroCount;

    /**
     * 大型顾客消费额
     */
    private Double bigConsumption;

    /**
     * A类顾客消费额
     */
    private Double aConsumption;

    /**
     * B类顾客消费额
     */
    private Double bConsumption;

    /**
     * C类顾客消费额
     */
    private Double cConsumption;

    /**
     * D类顾客消费额
     */
    private Double dConsumption;

    /**
     * E类顾客消费额
     */
    private Double eConsumption;

    public ConsumptionAbilityRecord toConsumptionAbilityRecord(){
        ConsumptionAbilityRecord consumptionAbilityRecord = new ConsumptionAbilityRecord()
                .setAConsumption(aConsumption)
                .setBConsumption(bConsumption)
                .setBigConsumption(bigConsumption)
                .setCConsumption(cConsumption)
                .setDConsumption(dConsumption)
                .setEConsumption(eConsumption)
                .setACount(aCount)
                .setBCount(bCount)
                .setBigCount(bigCount)
                .setCCount(cCount)
                .setDCount(dCount)
                .setECount(eCount)
                .setZeroCount(zeroCount);
        return consumptionAbilityRecord;
    }

}