package com.zkl.taishou.service.user;

import com.zkl.taishou.common.entity.User;
import com.zkl.taishou.common.result.ResultBean;

public interface UserService {

    User getUsers();

    User getUserByRegisterId(String phone );

    boolean addUser(User user);

    boolean modifyUserById(User user);

    boolean removeUserById(Integer id);

    ResultBean login(String phone,String password);

    ResultBean register(User user);
}
