package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.DiagnoseVO;
import com.zkl.taishou.common.VO.ProfitDiagnosisVO;
import com.zkl.taishou.common.VO.StoreCostStructureVO;
import com.zkl.taishou.common.entity.DiagnoseRecord;
import com.zkl.taishou.common.entity.ProfitDiagnosisRecord;
import com.zkl.taishou.common.entity.StoreCostStructureRecord;
import com.zkl.taishou.dao.diagnose.DiagnoseRecordDAO;
import com.zkl.taishou.dao.diagnose.ProfitDiagnosisRecordDAO;
import com.zkl.taishou.dao.diagnose.StoreCostStructureRecordDAO;
import com.zkl.taishou.service.BaseService;
import com.zkl.taishou.service.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/19-14:58
 * @Version:
 */
@Service
public class DiagnoseServiceImpl  extends BaseService implements DiagnoseService {

    @Autowired
    private DiagnoseRecordDAO diagnoseRecordMapper;
    @Autowired
    private StoreCostStructureRecordDAO storeCostStructureRecordMapper;
    @Autowired
    private ProfitDiagnosisRecordDAO profitDiagnosisRecordDAO;

    @Override
    public void recordDiagnosis(DiagnoseVO diagnoseVO) {
        DiagnoseRecord diagnoseRecord = diagnoseVO.toDiagnoseRecord();
        diagnoseRecordMapper.insertSelective(diagnoseRecord);
    }

    @Override
    public void recordStoreCostStructure(StoreCostStructureVO storeCostStructureVO) {
        StoreCostStructureRecord storeCostStructureRecord = storeCostStructureVO.toStoreCostStructure();
        storeCostStructureRecordMapper.insertSelective(storeCostStructureRecord);
    }

    @Override
    public void recordProfitDiagnosisRecord(ProfitDiagnosisVO profitDiagnosisVO) {
        ProfitDiagnosisRecord profitDiagnosisRecord = profitDiagnosisVO.toProfitDiagnosisRecord();
        profitDiagnosisRecordDAO.insertSelective(profitDiagnosisRecord);
    }
}
