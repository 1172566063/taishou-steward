package com.zkl.taishou.controller;

import com.zkl.taishou.common.PO.CalculateResultPO;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.service.CalculateService;
import io.swagger.annotations.Api;
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

import java.util.List;

/**
 * @ClassName: 测算系统
 * @Author ：lishixiang
 * @Date：2020/5/9-9:53
 * @Version:
 */
@Api("测算")
@RestController
@RequestMapping("/calculate")
public class CalculateController extends BaseController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/")
    @ApiOperation(value = "测算",notes = "测算系统第一步")
    @ApiImplicitParams ({
            @ApiImplicitParam(name="calculateStepOne",value = "测算系统第一步",paramType = "body",dataType = "CalculateStepOne"),
            @ApiImplicitParam(name="token",value = "用户token",paramType = "header")
    })
    public ResultBean<List<CalculateResultPO>> calculate(@Validated @RequestBody CalculateStepOneVO calculateStepOne, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        calculateStepOne.setUserId(getCurrLoginUser().getId());
        List<CalculateResultPO> calculateResultPO = sendMessage(this.topic, calculateStepOne);
        return new ResultBean<>(calculateResultPO);
    }


}
