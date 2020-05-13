package com.zkl.taishou.service;

import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.VO.CalculateStepOne;
/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/9-10:52
 * @Version:
 */
public interface CalculateService {

    ResultBean calculate(CalculateStepOne calculateStepOne);

    void recordResult(CalculateStepOne calculateStepOne);
}
