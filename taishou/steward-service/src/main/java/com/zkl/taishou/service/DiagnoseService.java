package com.zkl.taishou.service;

import com.zkl.taishou.common.VO.DiagnoseVO;
import com.zkl.taishou.common.VO.ProfitDiagnosisVO;
import com.zkl.taishou.common.VO.StoreCostStructureVO;
import com.zkl.taishou.common.entity.ProfitDiagnosisRecord;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/19-14:57
 * @Version:
 */
public interface DiagnoseService{

    void recordDiagnosis(DiagnoseVO diagnoseVO);

    void recordStoreCostStructure(StoreCostStructureVO storeCostStructureVO);

    void recordProfitDiagnosisRecord(ProfitDiagnosisVO profitDiagnosisVO);
}
