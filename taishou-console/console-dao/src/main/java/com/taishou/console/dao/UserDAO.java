/* https://github.com/orange1438 */
package com.taishou.console.dao;

import com.taishou.console.common.PO.UserEchoInfoPO;
import com.taishou.console.common.entity.User;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2020-06-02 17:43:07
 */
public interface UserDAO {
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
    int insert(User record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(User record);

    /** 
     * 根据ID查询
     * @param id 主键ID
     * @return 返回查询的结果
     */
    User selectByPrimaryKey(Integer id);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(User record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据手机号获取用户信息
     * @return
     */
    User selectUserByPhone(String phone);

    /**
     * 批量获取用户信息
     * @return
     */
    List<UserEchoInfoPO> selectAllUserInfos();

}