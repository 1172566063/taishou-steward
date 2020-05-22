package com.zkl.taishou.common.entity.diagnose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DiagnoseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Double basicItem;

    private Double featuresItem;

    private Double bigItem;

    private Double homeAndOutside;

    private Date createTime;

    private Long resultId;

    private Long type;

}