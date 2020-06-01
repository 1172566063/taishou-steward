/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.user;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户使用记录 user_operation_record
 * @author orange1438 code generator
 * date:2020-05-31 16:40:02
 */
public class UserOperationRecord implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -3927491630482066137L;

    /** 
     */ 
    private Integer id;

    /** 
     * 用户手机号
     */ 
    private String userPhone;

    /** 
     * 用户操作
     */ 
    private String operation;

    /** 
     */ 
    private Date createTime;

    /** 
     * 获取 user_operation_record.id
     * @return user_operation_record.id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 user_operation_record.id
     * @param id user_operation_record.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 用户手机号 user_operation_record.user_phone
     * @return 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /** 
     * 设置 用户手机号 user_operation_record.user_phone
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /** 
     * 获取 用户操作 user_operation_record.operation
     * @return 用户操作
     */
    public String getOperation() {
        return operation;
    }

    /** 
     * 设置 用户操作 user_operation_record.operation
     * @param operation 用户操作
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /** 
     * 获取 user_operation_record.create_time
     * @return user_operation_record.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 user_operation_record.create_time
     * @param createTime user_operation_record.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", operation=").append(operation);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}