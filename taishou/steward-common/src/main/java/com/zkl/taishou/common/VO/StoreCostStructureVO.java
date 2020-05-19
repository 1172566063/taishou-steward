package com.zkl.taishou.common.VO;

import com.zkl.taishou.common.entity.StoreCostStructureRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/19-15:40
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StoreCostStructureVO implements Serializable {

    private static final long serialVersionUid = -1L;

    private Integer userId;

    /**
     * 产品进货成本
     */
    @ApiModelProperty(value = "产品进货成本",required = true,example = "0")
    private Double purchaseCost;

    /**
     * 仪器设备产品
     */
    @ApiModelProperty(value = "仪器设备产品",required = true,example = "0")
    private Double instrumentCost;

    /**
     * 工资提成成本
     */
    @ApiModelProperty(value = "工资提成成本",required = true,example = "0")
    private Double wageCost;

    /**
     * 房租水电成本
     */
    @ApiModelProperty(value = "房租水电成本",required = true,example = "0")
    private Double rentAndUtilities;

    /**
     * 营销费用成本
     */
    @ApiModelProperty(value = "营销费用成本",required = true,example = "0")
    private Double marketingCost;

    /**
     * 管理费用成本
     */
    @ApiModelProperty(value = "管理费用成本",required = true,example = "0")
    private Double managementCost;

    /**
     * 其他成本
     */
    @ApiModelProperty(value = "其他成本",required = true,example = "0")
    private Double otherCost;

    public StoreCostStructureRecord toStoreCostStructure(){
        StoreCostStructureRecord storeCostStructureRecord = new StoreCostStructureRecord()
                .setInstrumentCost(instrumentCost)
                .setManagementCost(managementCost)
                .setMarketingCost(marketingCost)
                .setOtherCost(otherCost)
                .setPurchaseCost(purchaseCost)
                .setWageCost(wageCost)
                .setRentAndUtilities(rentAndUtilities);
        return storeCostStructureRecord;
    }
}
