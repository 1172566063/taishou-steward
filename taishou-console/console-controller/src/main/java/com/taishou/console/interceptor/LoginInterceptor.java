package com.taishou.console.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: 登录拦截器
 * @Author ：lishixiang
 * @Date：2020/5/8-21:38
 * @Version:
 */
@SpringBootConfiguration
public class LoginInterceptor extends WebMvcConfigurerAdapter {

    @Autowired
    private UserConfig userConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userConfig)
                .addPathPatterns("/**")
                .excludePathPatterns("/*/user/login")
                .excludePathPatterns("/*/user/register")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**","/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
