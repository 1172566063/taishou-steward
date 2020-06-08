package com.taishou.console.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取yml文件属性工具类
 *
 * @author LiShiXiang
 * @date: 2017/7/7 0:54:16
 */
public class PropsUtil {
    private static Properties props = new Properties();
    private static InputStream isp = PropsUtil.class.getClassLoader().getResourceAsStream("application-attribute.yml");

    public static String get(String arg) throws IOException {
        props.load(new InputStreamReader(isp, "utf-8"));
        String result = props.getProperty(arg);
        return result;
    }

    public static String getString(String arg){
        try {
            props.load(new InputStreamReader(isp, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = props.getProperty(arg);
        return result;
    }

    public static String get(String arg, String arg2) throws IOException {
        props.load(new InputStreamReader(isp, "utf-8"));
        String result = props.getProperty(arg) + props.getProperty(arg2);
        return result;
    }

    public static String getNoE(String arg) {
        try {
            props.load(new InputStreamReader(isp, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = props.getProperty(arg);
        return result;
    }
    public static String getNoE(String arg1, String arg2) {
        try {
            props.load(new InputStreamReader(isp, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = props.getProperty(arg1) + props.getProperty(arg2);
        return result;
    }
}
