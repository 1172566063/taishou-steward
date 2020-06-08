package com.taishou.console.interceptor;

import com.alibaba.fastjson.JSONObject;

import com.taishou.console.common.constants.RedisKeyConstants;
import com.taishou.console.service.RedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName: 切面->统计诊断与测算
 * @Author ：lishixiang
 * @Date：2020/5/30-21:38
 * @Version:
 */
//@Component
//@Aspect
public class StatisticsSection  {

    @Autowired
    RedisService redisService;

    //@Pointcut("execution(public * com.taishou.console.controller.CalculateController.*(..))")
    public void record(){
    }

    @After("record()")
    public void doAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();// 获得目标方法名
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("operation",method);
        jsonObject.put("token",token);
        redisService.addMessage(RedisKeyConstants.USER_OPERATION,jsonObject.toJSONString());
    }

}
