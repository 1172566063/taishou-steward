package com.taishou.console.interceptor;

import com.alibaba.fastjson.JSON;
import com.taishou.console.common.constants.RedisKeyConstants;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.constants.ResultConstants;
import com.taishou.console.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: 用户登陆信息与token存储
 * @Author ：lishixiang
 * @Date：2020/5/8-21:38
 * @Version:
 */
@Component
public class UserConfig implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            ResultBean resultBean=new ResultBean(ResultConstants.NOT_LOGIN);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(resultBean));
            return false;
        }
        String userPhone=redisService.get(RedisKeyConstants.LOGIN_USER+token);
        if(StringUtils.isNotBlank(userPhone)){
            redisService.setPastDueTime(RedisKeyConstants.LOGIN_USER+token, RedisKeyConstants.ONE_WEEK);
            redisService.setPastDueTime(RedisKeyConstants.LOGIN_USER+userPhone,RedisKeyConstants.ONE_WEEK);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
