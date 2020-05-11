package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.CalculateStepOne;
import com.zkl.taishou.common.VO.CalculateStepTwo;
import com.zkl.taishou.common.result.ResultBean;
import com.zkl.taishou.service.CalculateService;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/9-10:53
 * @Version:
 */
@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public ResultBean calculate(CalculateStepOne calculateStepOne) {
        return new ResultBean<CalculateStepOne>(calculateStepOne);
    }
}
