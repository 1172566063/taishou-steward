package com.zkl.taishou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateRecord {

    private Long id;

    private Long userId;

    private Long area;

    private Long roomNum;

    private Long bedNum;

    private Long staffNum;

    private Long clientNum;

    private Date createTime;

    private String reserved;

    private String generateReport;

    private String reportAddress;


}