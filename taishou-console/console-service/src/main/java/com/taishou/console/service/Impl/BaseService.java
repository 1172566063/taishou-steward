package com.taishou.console.service.Impl;

import com.alibaba.fastjson.JSON;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.constants.ResultConstants;
import com.taishou.console.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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


    /**
     * 获取成功返回结果
     *
     * @param
     * @return
     * @author LiShiXiang
     */
    protected <T> ResultBean getSuccessResult() {
        return new ResultBean<T>(ResultConstants.SUCCESS);
    }

    /**
     * 获取成功返回结果
     *
     * @param data
     * @return
     * @author LiShiXiang
     */
    protected <T> ResultBean getSuccessResult(T data) {
        ResultBean<T> appResult = getSuccessResult();
        appResult.setData(data);
        return appResult;
    }

    /**
     * 成功返回  带数据和提示
     *
     * @param data
     * @return
     */
    protected <T>ResultBean getSuccessResult(T data, String msg) {
        ResultBean<T> appResult = getSuccessResult();
        appResult.setData(data);
        appResult.setRetMsg(msg);
        return appResult;
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
