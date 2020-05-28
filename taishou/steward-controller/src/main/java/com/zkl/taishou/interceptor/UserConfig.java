package com.zkl.taishou.interceptor;

import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.constants.ResultConstants;
import com.zkl.taishou.service.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserConfig implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            String userId=redisService.get(RedisKeyConstants.LOGIN_USER+token);
            if(StringUtils.isNotBlank(userId)){
                redisService.setPastDueTime(RedisKeyConstants.LOGIN_USER+token, RedisKeyConstants.ONE_WEEK);
                redisService.setPastDueTime(RedisKeyConstants.LOGIN_USER+userId,RedisKeyConstants.ONE_WEEK);
                return true;
            }
        }
        ResultBean resultBean=new ResultBean(ResultConstants.NOT_LOGIN);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(resultBean));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
