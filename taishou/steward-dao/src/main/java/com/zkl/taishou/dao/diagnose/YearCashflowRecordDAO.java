/* https://github.com/orange1438 */
package com.zkl.taishou.dao.diagnose;

import com.zkl.taishou.common.entity.diagnose.YearCashFlowRecord;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2020-05-22 14:20:35
 */
public interface YearCashflowRecordDAO {
    /** 
     * 根据ID删除
     * @param id 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(Integer id);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(YearCashFlowRecord record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(YearCashFlowRecord record);

    /** 
     * 根据ID查询
     * @param id 主键ID
     * @return 返回查询的结果
     */
    YearCashFlowRecord selectByPrimaryKey(Integer id);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(YearCashFlowRecord record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(YearCashFlowRecord record);
}