package com.zkl.taishou.controller;

import com.zkl.taishou.common.VO.DiagnoseVO;
import com.zkl.taishou.common.constants.ResultBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: 添加诊断记录
 * @Author ：lishixiang
 * @Date：2020/5/19-11:37
 * @Version:
 */
@RestController
@RequestMapping("/diagnose")
public class DiagnoseController extends BaseController {

    public ResultBean diagnose(@RequestBody @Validated DiagnoseVO diagnoseVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        diagnoseVO.setUserId(getCurrLoginUser().getId());
        return null;
    }
}
