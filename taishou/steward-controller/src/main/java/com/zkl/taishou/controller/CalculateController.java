package com.zkl.taishou.controller;

import com.zkl.taishou.common.result.ResultBean;
import com.zkl.taishou.common.VO.CalculateStepOne;
import com.zkl.taishou.common.result.ResultConstants;
import com.zkl.taishou.service.CalculateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: 测算系统
 * @Author ：lishixiang
 * @Date：2020/5/9-9:53
 * @Version:
 */
@RestController
@RequestMapping("/calculate")
public class CalculateController extends BaseController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/")
    @ApiOperation(value = "测算",notes = "测算系统第一步")
    @ApiImplicitParam(name="form",value = "测算系统第一步",paramType = "CalculateStepOne")
    public ResultBean<CalculateStepOne> calculate(@Validated @RequestBody CalculateStepOne calculateStepOne, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
       return calculateService.calculate(calculateStepOne);
    }
}
