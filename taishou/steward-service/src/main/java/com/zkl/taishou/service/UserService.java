package com.zkl.taishou.service;

import com.zkl.taishou.common.PO.UserInfo;
import com.zkl.taishou.common.VO.RegisterVO;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.common.constants.ResultBean;

public interface UserService {

    User getUsers();

    User getUserByRegisterId(String phone );

    boolean addUser(User user);

    boolean modifyUserById(User user);

    boolean removeUserById(Integer id);

    ResultBean<UserInfo> login(String phone, String password);

    ResultBean<UserInfo> register(RegisterVO registerVO);
}
