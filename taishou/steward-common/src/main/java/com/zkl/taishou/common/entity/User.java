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
public class User implements Serializable {

    private static final long serialVersionUid = 1L;

    private Long id;

    private String name;

    private Integer sex;

    private Integer age;

    private Integer roleId;

    private String wxUnionid;

    private String phone;

    private String password;

    private String headPortraitImg;

    private Role role;

}