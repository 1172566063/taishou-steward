package com.zkl.taishou.controller.user;

import com.zkl.taishou.common.PO.UserInfo;
import com.zkl.taishou.common.VO.RegisterVO;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.controller.BaseController;
import com.zkl.taishou.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/8-16:53
 * @Version:
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",paramType = "query",value = "用户手机号"),
            @ApiImplicitParam(name = "password",paramType = "query", value = "用户密码"),
    })
    @PostMapping("/login")
    public ResultBean<UserInfo> login(String phone, String password){
        return userService.login(phone,password);
    }

    @ApiOperation(value = "用户注册",notes = "注册")
    @ApiImplicitParam(name="registerVO" ,value = "用户注册表单",dataType = "RegisterVO",paramType = "body")
    @PostMapping("/register")
    public ResultBean getUserRol(@Validated @RequestBody RegisterVO registerVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        return userService.register(registerVO);
    }

    @ApiOperation(value = "登出用户",notes = "用户退出登录")
    @ApiImplicitParam(name = "token",value = "用户token",paramType = "header")
    @PostMapping("/logout")
    public ResultBean logout(){
        LogoutUser();
        return new ResultBean();
    }
}
