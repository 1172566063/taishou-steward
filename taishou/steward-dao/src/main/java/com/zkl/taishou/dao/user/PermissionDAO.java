package com.zkl.taishou.dao.user;

import com.zkl.taishou.common.entity.Permission;

import java.util.List;

public interface PermissionDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectPermissionsByRoleId(long roleId);

}