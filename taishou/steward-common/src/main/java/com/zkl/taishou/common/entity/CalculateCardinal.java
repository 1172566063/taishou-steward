package com.zkl.taishou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CalculateCardinal implements Serializable {

    private final static long serialVersionUid = -1L;

    private String name;

    private Double value;

    private Integer type;

    private String explain;

}