/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import java.io.Serializable;
import java.util.Date;

/** 
 * 员工指标诊断数据关联表 employee_indicators
 * @author orange1438 code generator
 * date:2020-05-29 09:30:53
 */
public class EmployeeIndicators implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2112946076145484232L;

    /** 
     */ 
    private Integer id;

    /** 
     * 员工id
     */ 
    private Integer staffId;

    /** 
     * 值
     */ 
    private Double value;

    /** 
     * 分组id
     */ 
    private Integer groupId;

    /** 
     * 诊断类型 
1 现金业务诊断
2 耗卡业绩诊断
3 消耗比（现金业绩）
4 消耗比（ 耗卡业绩）
5 客流诊断
6 客单价诊断
7 项目数诊断
8 项目单价诊断
9 新客数诊断
     */ 
    private Integer type;

    /** 
     */ 
    private Date createTime;

    /** 
     * 获取 employee_indicators.id
     * @return employee_indicators.id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 employee_indicators.id
     * @param id employee_indicators.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 员工id employee_indicators.staff_id
     * @return 员工id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * 设置 员工id employee_indicators.staff_id
     * @param staffId 员工id
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * 获取 值 employee_indicators.value
     * @return 值
     */
    public Double getValue() {
        return value;
    }

    /** 
     * 设置 值 employee_indicators.value
     * @param value 值
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /** 
     * 获取 分组id employee_indicators.group_id
     * @return 分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /** 
     * 设置 分组id employee_indicators.group_id
     * @param groupId 分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /** 
     * 获取 诊断类型 
1 现金业务诊断
2 耗卡业绩诊断
3 消耗比（现金业绩）
4 消耗比（ 耗卡业绩）
5 客流诊断
6 客单价诊断
7 项目数诊断
8 项目单价诊断
9 新客数诊断 employee_indicators.type
     * @return 诊断类型 
1 现金业务诊断
2 耗卡业绩诊断
3 消耗比（现金业绩）
4 消耗比（ 耗卡业绩）
5 客流诊断
6 客单价诊断
7 项目数诊断
8 项目单价诊断
9 新客数诊断
     */
    public Integer getType() {
        return type;
    }

    /** 
     * 设置 诊断类型 
1 现金业务诊断
2 耗卡业绩诊断
3 消耗比（现金业绩）
4 消耗比（ 耗卡业绩）
5 客流诊断
6 客单价诊断
7 项目数诊断
8 项目单价诊断
9 新客数诊断 employee_indicators.type
     * @param type 诊断类型 
1 现金业务诊断
2 耗卡业绩诊断
3 消耗比（现金业绩）
4 消耗比（ 耗卡业绩）
5 客流诊断
6 客单价诊断
7 项目数诊断
8 项目单价诊断
9 新客数诊断
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 
     * 获取 employee_indicators.create_time
     * @return employee_indicators.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 employee_indicators.create_time
     * @param createTime employee_indicators.create_time
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
        sb.append(", staffId=").append(staffId);
        sb.append(", value=").append(value);
        sb.append(", groupId=").append(groupId);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}