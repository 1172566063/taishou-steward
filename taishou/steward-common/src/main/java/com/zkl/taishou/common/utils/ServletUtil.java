package com.zkl.taishou.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * servlet 工具类
 *
 * @author LiShiXiang
 */
public class ServletUtil {

    private static final String NUKNOWN = "unknown";

    /**
     * ip address头部类型
     */
    private static final String[] IP_ADDR_HEADER = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "X-Real-IP"};

    /**
     * 获取httpservletrequest请求
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes reqAttrs = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) reqAttrs;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    /**
     * 从httpservlet中根据请求参数名称获取参数值
     *
     * @param paramName
     * @return
     */
    public static String getRequestParams(String paramName) {
        return getRequest().getParameter(paramName);
    }

    /**
     * 获得真实IP地址。在使用了反向代理时
     * 直接用HttpServletRequest.getRemoteAddr()无法获取客户真实的IP地址。
     *
     * @param request
     * @return
     * @author 刘献廷
     */
    public static String getIp(ServletRequest request) {
        String addr = null;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest hsr = (HttpServletRequest) request;
            for (String header : IP_ADDR_HEADER) {
                if (StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
                    addr = hsr.getHeader(header);
                } else {
                    break;
                }
            }
        }
        if (StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
            addr = request.getRemoteAddr();
        } else {
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按','分割
            int i = addr.indexOf(",");
            if (i > 0) {
                addr = addr.substring(0, i);
            }
        }
        return addr;
    }
}
