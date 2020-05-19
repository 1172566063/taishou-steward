package com.zkl.taishou.controller;

import com.zkl.taishou.common.VO.DiagnoseVO;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.service.DiagnoseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    DiagnoseService diagnoseService;


    @PostMapping("/")
    @ApiOperation(value = "诊断",notes = "运营环境诊断与营销业绩诊断")
    @ApiImplicitParams({
            @ApiImplicitParam(name="diagnoseVO",value = "测算系统第一步",paramType = "body",dataType = "DiagnoseVO"),
            @ApiImplicitParam(name="token",value = "用户token",paramType = "header")
    })
    public ResultBean diagnose(@RequestBody @Validated DiagnoseVO diagnoseVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        diagnoseVO.setUserId(getCurrLoginUser().getId());
        return null;
    }
}
