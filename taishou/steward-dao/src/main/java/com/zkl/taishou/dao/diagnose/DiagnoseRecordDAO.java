package com.zkl.taishou.dao.diagnose;

import com.zkl.taishou.common.entity.diagnose.DiagnoseRecord;

public interface DiagnoseRecordDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(DiagnoseRecord record);

    int insertSelective(DiagnoseRecord record);

    DiagnoseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiagnoseRecord record);

    int updateByPrimaryKey(DiagnoseRecord record);
}