package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.CalculateStepOne;
import com.zkl.taishou.common.constants.CommonalityProperty;
import com.zkl.taishou.common.entity.CalculateRecord;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.dao.calculate.CalculateRecordMapper;
import com.zkl.taishou.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/9-10:53
 * @Version:
 */
@Service
public class CalculateServiceImpl implements CalculateService {


    @Autowired
    CalculateRecordMapper calculateRecordMapper;

    @Override
    public ResultBean calculate(CalculateStepOne calculateStepOne) {
        recordResult(calculateStepOne);
        return new ResultBean<CalculateStepOne>(calculateStepOne);
    }

    @Override
    public void recordResult(CalculateStepOne calculateStepOne) {
        CalculateRecord calculateRecord = calculateStepOne.toCalculateRecord();
        calculateRecord.setGenerateReport(CommonalityProperty.NO);
        calculateRecord.setCreateTime(new Date());
        calculateRecordMapper.insert(calculateRecord);
    }


}
