package com.zkl.taishou.service.user.Impl;

import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.User;
import com.zkl.taishou.common.result.ResultBean;
import com.zkl.taishou.common.result.ResultConstants;
import com.zkl.taishou.common.utils.EncryptUtil;
import com.zkl.taishou.dao.user.PermissionMapper;
import com.zkl.taishou.dao.user.UserMapper;
import com.zkl.taishou.service.BaseService;
import com.zkl.taishou.service.user.UserService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public User getUsers() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public User getUserByRegisterId(String phone) {
        User userByRegister = userMapper.getUserByRegisterId(phone);
        userByRegister.getRole().setPermissions(permissionMapper.selectPermissionsByRoleId(userByRegister.getRole().getId()));
        return userByRegister;
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user)>0;
    }

    @Override
    public boolean modifyUserById(User user) {
        return userMapper.updateUserById(user)>0;
    }

    @Override
    public boolean removeUserById(Integer id) {
        return userMapper.deleteUserById(id)>0;
    }

    @Override
    public ResultBean login(String phone, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phone, password);
        String token=null;
        try {
            subject.login(usernamePasswordToken);
            User userInfo=(User)subject.getPrincipal();
            //登录  redis存储token
            token = redisService.userLogin(userInfo, RedisKeyConstants.ONE_DAY);
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultBean(ResultConstants.LOGIN_FAlL);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return new ResultBean(ResultConstants.PERMISSION_DENIED);
        }
        return new ResultBean(token);
    }

    @Override
    public ResultBean register(User user) {
        String account= user.getPhone();
        String password = user.getPassword();
        User userByRegisterId = getUserByRegisterId(account);
        if(userByRegisterId!=null){
            return new ResultBean(ResultConstants.ACCOUNT_REPETITION);
        }
        user.setPassword(EncryptUtil.PawEncryption(account,password));
        userMapper.insert(user);

        return login(account,password);
    }
}
