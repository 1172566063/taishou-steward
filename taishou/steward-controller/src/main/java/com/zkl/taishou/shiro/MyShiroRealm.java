package com.zkl.taishou.shiro;


import com.zkl.taishou.common.entity.user.Permission;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //角色权限和对应权限添加
    //Authorization授权，将数据库中的角色和权限授权给输入的用户名
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录的用户名
        String registerId = (String) principalCollection.getPrimaryPrincipal();
        //到数据库里查询要授权的内容
        User user = userService.getUserByRegisterId(registerId);
        //记录用户的所有角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();//权限信息
        simpleAuthorizationInfo.addRole(user.getRole().getRole());
        for (Permission p : user.getRole().getPermissions()) {
            //将所有的角色信息添加进来。
            simpleAuthorizationInfo.addStringPermission(p.getPermission());
        }
        return simpleAuthorizationInfo;

    }

    /**
     * 权限认证
     *
     * @return
     * @prama
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String registerId = authenticationToken.getPrincipal().toString();
        User user = userService.getUserByRegisterId(registerId);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(registerId), getName());

            return simpleAuthenticationInfo;
        }
    }


}
