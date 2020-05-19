package com.zkl.taishou.dao.diagnose;

import com.zkl.taishou.common.entity.StoreCostStructureRecord;

public interface StoreCostStructureRecordDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(StoreCostStructureRecord record);

    int insertSelective(StoreCostStructureRecord record);

    StoreCostStructureRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoreCostStructureRecord record);

    int updateByPrimaryKey(StoreCostStructureRecord record);
}