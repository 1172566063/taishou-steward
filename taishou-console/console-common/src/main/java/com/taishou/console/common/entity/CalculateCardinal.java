/* https://github.com/orange1438 */
package com.taishou.console.common.entity;

import java.io.Serializable;

/** 
 * 测算基值与规则表 calculate_cardinal
 * @author orange1438 code generator
 * date:2020-06-02 18:48:05
 */
public class CalculateCardinal implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 4753252833177633292L;

    /** 
     * 属性名
     */ 
    private String name;

    /** 
     * 属性值
     */ 
    private Double value;

    /** 
     * 属性类型
     */ 
    private Integer type;

    /** 
     * 说明
     */ 
    private String explain;

    /** 
     * 获取 属性名 calculate_cardinal.name
     * @return 属性名
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 属性名 calculate_cardinal.name
     * @param name 属性名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 属性值 calculate_cardinal.value
     * @return 属性值
     */
    public Double getValue() {
        return value;
    }

    /** 
     * 设置 属性值 calculate_cardinal.value
     * @param value 属性值
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /** 
     * 获取 属性类型 calculate_cardinal.type
     * @return 属性类型
     */
    public Integer getType() {
        return type;
    }

    /** 
     * 设置 属性类型 calculate_cardinal.type
     * @param type 属性类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 
     * 获取 说明 calculate_cardinal.explain
     * @return 说明
     */
    public String getExplain() {
        return explain;
    }

    /** 
     * 设置 说明 calculate_cardinal.explain
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", type=").append(type);
        sb.append(", explain=").append(explain);
        sb.append("]");
        return sb.toString();
    }
}