package com.zkl.taishou.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//登录拦截器
@SpringBootConfiguration
public class LoginInterceptor extends WebMvcConfigurerAdapter {

    @Autowired
    private UserConfig userConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userConfig)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}
