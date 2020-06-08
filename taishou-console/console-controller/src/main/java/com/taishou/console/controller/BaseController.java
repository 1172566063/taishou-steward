package com.taishou.console.controller;

import com.alibaba.fastjson.JSON;
import com.taishou.console.common.constants.RedisKeyConstants;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.constants.ResultConstants;
import com.taishou.console.common.entity.FileInfo;
import com.taishou.console.common.entity.User;
import com.taishou.console.common.utils.ServletUtil;
import com.taishou.console.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.validation.BindingResult;
import javax.jms.Topic;
import javax.servlet.http.HttpServletRequest;


public class BaseController {

    @Autowired
    RedisService redisService;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    protected Topic topic;


    // 发送消息，destination是发送到的队列，message是待发送的消息
    protected ResultBean sendMessage(FileInfo message){
        return jmsMessagingTemplate.convertSendAndReceive(topic,message,ResultBean.class);
    }



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
        String userJson = redisService.get(RedisKeyConstants.LOGIN_USER + token);
        User user = copyTo(userJson, User.class);
        redisService.remove(RedisKeyConstants.LOGIN_USER + token);
        redisService.remove(RedisKeyConstants.LOGIN_USER + user.getPhone());
    }

    /**
     * 获取当前登录用户信息
     * 未登录返回null
     */
    protected User getCurrUser() {
        String token = getToken();
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

    protected String getToken(){
        HttpServletRequest request = ServletUtil.getRequest();
        String token = request.getHeader("token");
        return token;
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

}
