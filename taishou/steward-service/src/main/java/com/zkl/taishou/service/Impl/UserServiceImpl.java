package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.PO.UserInfo;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.User;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.constants.ResultConstants;
import com.zkl.taishou.common.utils.EncryptUtil;
import com.zkl.taishou.dao.user.PermissionDAO;
import com.zkl.taishou.dao.user.UserDAO;
import com.zkl.taishou.service.BaseService;
import com.zkl.taishou.service.UserService;
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
    UserDAO userMapper;

    @Autowired
    PermissionDAO permissionMapper;

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
    public ResultBean<UserInfo> login(String phone, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phone, password);
        String token=null;
        User user;
        try {
            subject.login(usernamePasswordToken);
            user=(User)subject.getPrincipal();
            //登录  redis存储token
            token = redisService.userLogin(user, RedisKeyConstants.ONE_DAY);
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultBean(ResultConstants.LOGIN_FAlL);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return new ResultBean(ResultConstants.PERMISSION_DENIED);
        }
        UserInfo userInfo=new UserInfo(user);
        userInfo.setToken(token);
        return new ResultBean(userInfo);
    }

    @Override
    public ResultBean<UserInfo> register(User user) {
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
