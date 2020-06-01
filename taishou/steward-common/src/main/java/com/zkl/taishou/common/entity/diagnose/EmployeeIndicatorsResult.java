/* https://github.com/orange1438 */
package com.zkl.taishou.common.entity.diagnose;

import java.io.Serializable;
import java.util.Date;

/** 
 * 员工指标诊断结果 employee_indicators_result
 * @author orange1438 code generator
 * date:2020-05-29 09:30:53
 */
public class EmployeeIndicatorsResult implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2120617133718879546L;

    /** 
     */ 
    private Integer id;

    /** 
     * 员工诊断数据 id
     */ 
    private Integer groupId;

    /** 
     * 结果
     */ 
    private Integer resultId;

    /** 
     */ 
    private Date createTime;

    /** 
     * 获取 employee_indicators_result.id
     * @return employee_indicators_result.id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 employee_indicators_result.id
     * @param id employee_indicators_result.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 员工诊断数据 id employee_indicators_result.group_id
     * @return 员工诊断数据 id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /** 
     * 设置 员工诊断数据 id employee_indicators_result.group_id
     * @param groupId 员工诊断数据 id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /** 
     * 获取 结果 employee_indicators_result.result_id
     * @return 结果
     */
    public Integer getResultId() {
        return resultId;
    }

    /** 
     * 设置 结果 employee_indicators_result.result_id
     * @param resultId 结果
     */
    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    /** 
     * 获取 employee_indicators_result.create_time
     * @return employee_indicators_result.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 employee_indicators_result.create_time
     * @param createTime employee_indicators_result.create_time
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
        sb.append(", groupId=").append(groupId);
        sb.append(", resultId=").append(resultId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}