package com.taishou.console.controller;

import com.taishou.console.common.PO.AdminLoginInfoPO;
import com.taishou.console.common.VO.*;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.constants.ResultConstants;
import com.taishou.console.common.entity.FileInfo;
import com.taishou.console.common.entity.PageInfo;
import com.taishou.console.common.entity.PageParam;
import com.taishou.console.common.entity.Store;
import com.taishou.console.common.utils.FileCorrelationUtil;
import com.taishou.console.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: 用户管理
 * @Author ：lishixiang
 * @Date：2020/6/3-9:37
 * @Version:
 */
@Api("用户模块")
@RestController
@RequestMapping("/v1/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("图片上传接口")
    @PostMapping("/picture/uploading")
    @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String")
    public ResultBean pictureUpload(@RequestParam("file") @ApiParam(value = "二进制文件流") MultipartFile file){
        if(!FileCorrelationUtil.checkFileSize( file.getSize(),100,"M")){
            return getFailResult(ResultConstants.FILE_TOO_BIG);
        }
        try {
            FileInfo fileInfo = new FileInfo()
                    .setFileBytes(file.getBytes())
                    .setFileName(file.getOriginalFilename());
            return sendMessage(fileInfo);
        }catch (IOException e){
            return getFailResult();
        }
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "increaseUserVO", value = "用户信息表单", paramType = "body", dataType = "IncreaseUserVO")
    })
    @PostMapping("/increase")
    public ResultBean increaseUser(@Validated @RequestBody IncreaseUserVO increaseUserVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getParameterFailResult(bindingResult);
        }
        return userService.addUser(increaseUserVO);
    }

    @ApiOperation(value = "登录", notes = "登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", paramType = "query", value = "用户手机号", defaultValue = "admin"),
            @ApiImplicitParam(name = "password", paramType = "query", value = "用户密码", defaultValue = "admin"),
    })
    @PostMapping("/login")
    public ResultBean<AdminLoginInfoPO> login(String phone, String password) {
        return userService.login(phone, password);
    }

    @ApiOperation(value = "用户管理", notes = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token"),
            @ApiImplicitParam(name = "pageParam", paramType = "body", value = "分页请求参数", dataType = "PageParam"),
    })
    @GetMapping("/users")
    public ResultBean<PageInfo> getUserList(@RequestBody PageParam pageParam) {
        return userService.getUserList(pageParam);
    }

    @ApiOperation("获取店铺信息")
    @GetMapping("/{userId}/stores")
    public ResultBean<List<Store>> removeStoresById(@PathVariable("userId") Long userId) {
        return userService.getUserStores(userId);
    }

    @ApiOperation("根据用户店铺id删除店铺")
    @DeleteMapping("/{storeId}/store")
    public ResultBean removeStoreById(@PathVariable("storeId") Long storeId) {
        return userService.removeStoreById(storeId);
    }

    @ApiOperation("根据员工id删除员工")
    @DeleteMapping("/{staffId}/staff")
    public ResultBean removeStaffById(@PathVariable("staffId") Long staffId) {
        return userService.removeStaffById(staffId);
    }


    @ApiOperation("修改店铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "storeVO", value = "店铺表单信息", paramType = "body", dataType = "StoreVO")
    })
    @PostMapping("/store/update")
    public ResultBean updateStore(@Validated @RequestBody StoreVO storeVO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        return userService.updateStoreById(storeVO);
    }

    @ApiOperation("修改员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "staffVO", value = "店员表单信息", paramType = "body", dataType = "StaffVO")
    })
    @PostMapping("/staff/update")
    public ResultBean updateStaff(@Validated @RequestBody StaffVO staffVO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        return userService.updateStaffById(staffVO);
    }


    @ApiOperation("用户信息修改")
    @PutMapping("/user/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "userUpdateVO", value = "用户信息表单", paramType = "body", dataType = "UserUpdateVO")
    })
    public ResultBean updateUserInfo(@RequestBody @Validated UserUpdateVO userUpdateVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        return userService.updateUserInfo(userUpdateVO);
    }

    @ApiOperation("添加管理员")
    @PutMapping("/admin/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "addAdminVO", value = "用户信息表单", paramType = "body", dataType = "AddAdminVO")
    })
    public ResultBean addUserInfo(@RequestBody @Validated AddAdminVO addAdminVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        return userService.addAdmin(addAdminVO);
    }
}