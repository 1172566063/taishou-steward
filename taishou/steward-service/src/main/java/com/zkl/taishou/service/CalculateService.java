package com.zkl.taishou.service;

import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/9-10:52
 * @Version:
 */
public interface CalculateService {

    //ResultBean calculate(CalculateStepOneVO calculateStepOne);

    void recordResult(CalculateStepOneVO calculateStepOne);


}
