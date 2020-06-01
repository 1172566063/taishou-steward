package com.zkl.taishou.common.constants;

/**
 * redis key常量类
 *
 * @author LiShiXiang
 */
public interface RedisKeyConstants {

    /**
     * 员工指标诊断 添加员工
     */
    String STAFF_INDEX = "STAFF_KEY";

    /**
     * 用户信息 登陆key
     */
    String LOGIN_USER="app_user_";

    /**
     * 一分钟
     */
    Integer ONE_MINUTE= 60;

    /**
     * 半小时
     */
    Integer THIRTY_MINUTE= 1800;

    /**
     * 一小时
     */
    Integer ONE_HOUR=360;

    /**
     * 一天
     */
    Integer ONE_DAY=86400;

    /**
     * 一星期
     */
    Integer ONE_WEEK= 604800;


    /**
     * 记录用户操做队列绑定键
     */
    String USER_OPERATION ="userOperation";
}
