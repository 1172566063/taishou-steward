package com.zkl.taishou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUid = 1L;

    private Integer id;

    private String permission;

}