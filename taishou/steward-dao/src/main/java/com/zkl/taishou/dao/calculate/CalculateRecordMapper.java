package com.zkl.taishou.dao.calculate;

import com.zkl.taishou.common.entity.CalculateRecord;

public interface CalculateRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CalculateRecord record);

    int insertSelective(CalculateRecord record);

    CalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalculateRecord record);

    int updateByPrimaryKey(CalculateRecord record);
}