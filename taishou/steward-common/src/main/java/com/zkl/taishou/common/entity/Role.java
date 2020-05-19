package com.zkl.taishou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Role implements Serializable {
    private static final long serialVersionUid = 1L;

    private Integer id;

    private String role;

    private List<Permission> permissions;

}