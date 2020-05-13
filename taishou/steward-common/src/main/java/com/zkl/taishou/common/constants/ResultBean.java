package com.zkl.taishou.common.constants;


import io.swagger.annotations.ApiModelProperty;

/**
 * 数据返回接口封装类
 *
 * @author TanXin
 */
public class ResultBean<T> {

    /**
     * 返回code
     */
    @ApiModelProperty(value = "状态码")
    private Integer retCode;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "提示语")
    private String retMsg;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "数据结果")
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T date) {
        this.retCode=ResultConstants.SUCCESS.getRetCode();
        this.retMsg=ResultConstants.SUCCESS.getRetMsg();
        this.data=date;
    }

    public ResultBean(ResultConstants constants) {
        super();
        this.retCode = constants.getRetCode();
        this.retMsg = constants.getRetMsg();
    }

    public ResultBean(Integer retCode, String retMsg) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Integer getRetCode() {return retCode; }

    public void setRetCode(Integer retCode) { this.retCode = retCode; }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
