package com.zkl.taishou.dao.diagnose;

import com.zkl.taishou.common.entity.DiagnoseRecord;

public interface DiagnoseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiagnoseRecord record);

    int insertSelective(DiagnoseRecord record);

    DiagnoseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiagnoseRecord record);

    int updateByPrimaryKey(DiagnoseRecord record);
}