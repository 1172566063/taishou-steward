package com.zkl.taishou.dao.user;

import com.zkl.taishou.common.entity.User;

public interface UserDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByRegisterId(String phone);

    Integer addUser(User user);

    Integer deleteUserById(Integer id);

    Integer updateUserById(User user);
}