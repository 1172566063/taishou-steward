package com.zkl.taishou.controller;

import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.constants.ResultConstants;
import com.zkl.taishou.common.utils.ServletUtil;
import com.zkl.taishou.service.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    RedisService redisService;

    /**
     * 获取当前登录用户信息
     * 未登录直接抛出异常
     *
     * @return
     * @author LiShiXiang
     */
    protected User getCurrLoginUser() {
        User currUser = getCurrUser();
        if (currUser == null) {
            throw new RuntimeException();
        }
        return currUser;
    }

    protected void LogoutUser(){
        HttpServletRequest request = ServletUtil.getRequest();
        String token = request.getHeader("token");
        String userJson = redisService.get(RedisKeyConstants.LOGIN_USER + "toke");
        User user = copyTo(userJson, User.class);
        redisService.remove(RedisKeyConstants.LOGIN_USER + "toke");
        redisService.remove(RedisKeyConstants.LOGIN_USER + user.getPhone());
    }

    /**
     * 获取当前登录用户信息
     * 未登录返回null
     */
    protected User getCurrUser() {
        HttpServletRequest request = ServletUtil.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            return null;
        }
        String currUserJson = redisService.get(RedisKeyConstants.LOGIN_USER + token);
        System.out.println(currUserJson + "-------------------------------");
        if (StringUtils.isBlank(currUserJson)) {
            return null;
        }
        User currUser = JSON.parseObject(currUserJson, User.class);

        return currUser;
    }

    /**
     * 实体复制
     *
     * @param obejct
     * @param clazz
     * @return
     * @author
     */
    protected static <T> T copyTo(Object obejct, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(obejct), clazz);
    }

    /**
     * 获取成功返回结果
     *
     * @param
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getSuccessResult() {
        return new ResultBean(ResultConstants.SUCCESS);
    }

    /**
     * 获取成功返回结果
     *
     * @param data
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getSuccessResult(Object data) {
        ResultBean appResult = getSuccessResult();
        appResult.setData(data);
        return appResult;
    }

    /**
     * 成功返回  带数据和提示
     *
     * @param data
     * @return
     */
    protected ResultBean getSuccessResult(Object data, String msg) {
        ResultBean appResult = getSuccessResult();
        appResult.setData(data);
        appResult.setRetMsg(msg);
        return appResult;
    }

    /**
     * 返回参数错误结果
     *
     * @param result
     * @return
     * @author ZhangZhongHua
     */
    protected ResultBean getParameterFailResult(BindingResult result) {
        return new ResultBean(ResultConstants.FAIL.getRetCode(), result.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 获取成功返回结果 带msg
     * @param msg
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getSuccessResult(String msg) {
        return new ResultBean(ResultConstants.SUCCESS.getRetCode(),msg);
    }


    /**
     * 获取失败返回结果
     *
     * @param failMsg
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getFailResult(String failMsg) {
        return new ResultBean(ResultConstants.FAIL.getRetCode(), failMsg);
    }


    /**
     * 获取失败返回结果
     *
     * @return
     * @author LiuShiXiang
     */
    protected ResultBean getFailResult() {
        return new ResultBean(ResultConstants.FAIL.getRetCode(), "");
    }

    /**
     * 获取失败返回结果
     *
     * @param constants
     * @return
     */
    protected ResultBean getFailResult(ResultConstants constants) {
        return new ResultBean(constants);
    }


    /**
     * 参数错误 返回msg
     * @param msg
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getParameterFailResult(String msg) {
        return new ResultBean(ResultConstants.FAIL.getRetCode(), msg);
    }

    /**
     * 参数错误结果  无参
     *
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getParameterFailResult() {
        return new ResultBean(ResultConstants.FAIL.getRetCode(), ResultConstants.FAIL.getRetMsg());
    }

    /**
     * 数据为空返回结果
     *
     * @param
     * @return
     * @author LiShiXiang
     */
    protected ResultBean getNullDataResult() {
        ResultBean resultBean = new ResultBean();
        resultBean.setRetCode(ResultConstants.NULL_DATA.getRetCode());
        resultBean.setRetMsg(ResultConstants.NULL_DATA.getRetMsg());
        return resultBean;
    }

}
