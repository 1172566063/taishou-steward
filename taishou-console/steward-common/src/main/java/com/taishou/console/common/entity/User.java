/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import java.io.Serializable;

/** 
 * @author orange1438 code generator
 * date:2020-06-02 17:41:42
 */
public class User implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2326823497273929349L;

    /** 
     */ 
    private Integer id;

    /** 
     * 名字
     */ 
    private String name;

    /** 
     * 性别 0女 1男  默认：1
     */ 
    private Integer sex;

    /** 
     * 年龄
     */ 
    private Integer age;

    /** 
     * 角色  默认：1
     */ 
    private Integer roleId;

    /** 
     * 微信凭证
     */ 
    private String wxUnionid;

    /** 
     * 手机号
     */ 
    private String phone;

    /** 
     * 密码
     */ 
    private String password;

    /** 
     * 头像地址
     */ 
    private String headPortraitImg;

    /** 
     * 获取 user.id
     * @return user.id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 user.id
     * @param id user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 名字 user.name
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 名字 user.name
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 性别 0女 1男 user.sex
     * @return 性别 0女 1男
     */
    public Integer getSex() {
        return sex;
    }

    /** 
     * 设置 性别 0女 1男 user.sex
     * @param sex 性别 0女 1男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /** 
     * 获取 年龄 user.age
     * @return 年龄
     */
    public Integer getAge() {
        return age;
    }

    /** 
     * 设置 年龄 user.age
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /** 
     * 获取 角色 user.role_id
     * @return 角色
     */
    public Integer getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色 user.role_id
     * @param roleId 角色
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 微信凭证 user.wx_unionid
     * @return 微信凭证
     */
    public String getWxUnionid() {
        return wxUnionid;
    }

    /** 
     * 设置 微信凭证 user.wx_unionid
     * @param wxUnionid 微信凭证
     */
    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid == null ? null : wxUnionid.trim();
    }

    /** 
     * 获取 手机号 user.phone
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /** 
     * 设置 手机号 user.phone
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /** 
     * 获取 密码 user.password
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /** 
     * 设置 密码 user.password
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /** 
     * 获取 头像地址 user.head_portrait_img
     * @return 头像地址
     */
    public String getHeadPortraitImg() {
        return headPortraitImg;
    }

    /** 
     * 设置 头像地址 user.head_portrait_img
     * @param headPortraitImg 头像地址
     */
    public void setHeadPortraitImg(String headPortraitImg) {
        this.headPortraitImg = headPortraitImg == null ? null : headPortraitImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", roleId=").append(roleId);
        sb.append(", wxUnionid=").append(wxUnionid);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", headPortraitImg=").append(headPortraitImg);
        sb.append("]");
        return sb.toString();
    }
}