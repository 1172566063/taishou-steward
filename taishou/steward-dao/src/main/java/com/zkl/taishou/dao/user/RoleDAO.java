package com.zkl.taishou.dao.user;

import com.zkl.taishou.common.entity.user.Role;

public interface RoleDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}