package com.zkl.taishou.dao.calculate;

import com.zkl.taishou.common.entity.calculate.CalculateCardinal;

import java.util.List;

public interface CalculateCardinalDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    int insert(CalculateCardinal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    int insertSelective(CalculateCardinal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    CalculateCardinal selectByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CalculateCardinal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calculate_cardinal
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CalculateCardinal record);

    /**
     * 获取所有测算规则
     * @return
     */
    List<CalculateCardinal> selectAll();
}