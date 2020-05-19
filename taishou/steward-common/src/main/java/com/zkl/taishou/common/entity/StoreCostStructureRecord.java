package com.zkl.taishou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class StoreCostStructureRecord implements Serializable {
    private Integer id;

    private Integer userId;

    private Double purchaseCost;

    private Double instrumentCost;

    private Double wageCost;

    private Double rentAndUtilities;

    private Double marketingCost;

    private Double managementCost;

    private Double otherCost;

    private Integer resultId;

    private Date createTime;

    private static final long serialVersionUID = 1L;


}