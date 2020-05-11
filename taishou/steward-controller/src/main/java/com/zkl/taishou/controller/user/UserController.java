package com.zkl.taishou.controller.user;

import com.zkl.taishou.common.entity.User;
import com.zkl.taishou.common.result.ResultBean;
import com.zkl.taishou.controller.BaseController;
import com.zkl.taishou.service.user.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiModelProperty(value = "登录",notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "用户手机号"),
            @ApiImplicitParam(name = "password", value = "用户密码"),
    })
    @PostMapping("/login")
    public ResultBean login(String phone, String password){
        return userService.login(phone,password);
    }

    @ApiOperation(value = "用户注册",notes = "注册")
    @ApiImplicitParam(name="form",value = "用户注册表单",paramType = "User")
    @GetMapping("/register")
    public ResultBean getUserRol(@Validated @RequestBody User user){
        return userService.register(user);
    }

    @ApiModelProperty(value = "登出用户",notes = "用户退出登录")
    @GetMapping("/logout")
    public ResultBean logout(){
        LogoutUser();
        return new ResultBean();
    }
}
