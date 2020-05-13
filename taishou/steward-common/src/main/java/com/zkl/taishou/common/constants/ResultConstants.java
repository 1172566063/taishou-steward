package com.zkl.taishou.common.constants;

/**
 * 结果常量类
 *
 * @author LiShiXiang
 */
public enum ResultConstants {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 失败
     */
    FAIL(201,"失败"),
    /**
     * 未登录
     */
    NOT_LOGIN(400, "未登录"),

    /**
     * 登录失败
     */
    LOGIN_FAlL(401,"账号或密码错误"),

    /**
     * 权限不足
     */
    PERMISSION_DENIED(402, "权限不足"),

    /**
     * 账号已存在
     */
    ACCOUNT_REPETITION(403,"账号已存在"),

    /**
     * 参数异常
     */
    PARRAMTER_EXCEPTION(406, "参数错误"),

    /**
     * 未实名
     */
//    NOT_REALNAME_AUTH("0005", "未实名"),



    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(500, "系统异常"),



    /**
     * 用戶错误操作
     */
    FAULTY_OPERATION(250,"用戶错误操作/输出系统提示语"),

    /**
     * 数据为空
     */
    NULL_DATA(204, "数据为空");



    /**
     * 结果值
     */
    private Integer retCode;

    /**
     * 结果信息
     */
    private String retMsg;

    ResultConstants(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
