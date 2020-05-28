package com.zkl.taishou.controller;

import com.zkl.taishou.common.PO.CalculateResultPO;
import com.zkl.taishou.common.constants.ResultBean;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.service.CalculateService;
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
    @ApiImplicitParams ({
            @ApiImplicitParam(name="calculateStepOne",value = "测算系统第一步",paramType = "body",dataType = "CalculateStepOne"),
            @ApiImplicitParam(name="token",value = "用户token",paramType = "header")
    })
    public ResultBean<CalculateResultPO> calculate(@Validated @RequestBody CalculateStepOneVO calculateStepOne, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }
        calculateStepOne.setUserId(getCurrLoginUser().getId());
       return calculateService.calculate(calculateStepOne);
    }


    /*@PostMapping("/record")
    @ApiOperation(value = "记录",notes = "添加测算记录")
    @ApiImplicitParam(name = "from",value = "测算数据表单",paramType = "CalculateStepOne")
    public ResultBean record(@Validated @RequestBody CalculateStepOne calculateStepOne,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return getParameterFailResult(bindingResult);
        }

        return new ResultBean();
    }*/

}
