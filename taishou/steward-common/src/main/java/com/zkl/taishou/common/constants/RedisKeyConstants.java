package com.zkl.taishou.common.constants;

/**
 * redis key常量类
 *
 * @author LiShiXiang
 */
public interface RedisKeyConstants {

    /**
     * 登陆key
     */
    String LOGIN_KEY = "app_login_";

    /**
     * 用户信息
     */
    String LOGIN_USER="app_user_";

    /**
     * 短信key
     */
    String SMS_REGISTER_KEY = "app_sms_register_";

    /**
     * 重置密码短信key
     */
    String RESET_PWD_SMS_KEY = "app_reset_pwd_";

    /**
     * 一分钟
     */
    Integer ONE_MINUTE= 60;

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
     * 视频历史
     */
    String VIDEO_KEY="EQUIPMENT_";

    /**
     * 记录被点赞用户
     */
    String LIKE_USER_KEY="LIKE_USER_";

    /**
     * 用户别名key
     */
    String USER_KEY="USER_CID_";

    /**
     * 用户别名key
     */
    String SELL_ORDER_KEY="SELL_ORDER_";

    /**
     * H5存储openid
     */
    String  WEB_WC_OPENID="USER_WC_OPENID_";

    /**
     * 用户关注
     */
    String COLLECT="USER_COLLECT_";

    /**
     * 用户关注
     */
    String ATTENTION="USER_ATTENTION_";

}
