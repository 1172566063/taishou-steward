/* https://github.com/orange1438 */
package com.taishou.console.dao;

import com.taishou.console.common.entity.CalculateCardinal;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2020-06-02 18:48:05
 */
public interface CalculateCardinalDAO {
    /** 
     * 根据ID删除
     * @param name
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(String name);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(CalculateCardinal record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(CalculateCardinal record);

    /** 
     * 根据ID查询
     * @param name
     * @return 返回查询的结果
     */
    CalculateCardinal selectByPrimaryKey(String name);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(CalculateCardinal record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(CalculateCardinal record);
}