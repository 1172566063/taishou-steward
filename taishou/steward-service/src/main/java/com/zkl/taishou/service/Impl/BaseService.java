package com.zkl.taishou.service.Impl;

import com.alibaba.fastjson.JSON;
import com.zkl.taishou.service.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/8-17:15
 * @Version:
 */
public class BaseService {

    private Logger LOGGER;

    @Autowired
    protected RedisService redisService;


    /**
     * 日志
     *
     * @param T
     * @param errorMessage
     * @author LiShiXiang
     */
    protected void loggerInfo(Class T, String errorMessage) {
        LOGGER = LoggerFactory.getLogger(T);
        LOGGER.info("*************loggerInfo:" + errorMessage);
    }

    /**
     * 日志
     *
     * @param T
     * @param errorMessage
     * @author LiShiXiang
     */
    protected void loggerError(Class T, String errorMessage) {
        LOGGER = LoggerFactory.getLogger(T);
        LOGGER.error("*************loggerError:" + errorMessage);
    }

    /**
     * 日志
     *
     * @param T
     * @param errorMessage
     * @author LiShiXiang
     */
    protected void loggerWarning(Class T, String errorMessage) {
        LOGGER = LoggerFactory.getLogger(T);
        LOGGER.warn("*************loggerWarn:" + errorMessage);
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
}
