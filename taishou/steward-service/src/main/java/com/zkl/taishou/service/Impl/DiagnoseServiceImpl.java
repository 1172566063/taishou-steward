package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.DiagnoseVO;
import com.zkl.taishou.common.entity.DiagnoseRecord;
import com.zkl.taishou.dao.diagnose.DiagnoseRecordMapper;
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
public class DiagnoseServiceImpl implements DiagnoseService {

    @Autowired
    private DiagnoseRecordMapper diagnoseRecordMapper;

    @Override
    public void recordDiagnosis(DiagnoseVO diagnoseVO) {
        DiagnoseRecord diagnoseRecord = diagnoseVO.toDiagnoseRecord();
        diagnoseRecordMapper.insertSelective(diagnoseRecord);
    }
}
