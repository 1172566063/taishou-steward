package com.zkl.taishou.controller;

import com.zkl.taishou.common.VO.StaffVO;
import com.zkl.taishou.service.StaffDiagnoseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: 员工指标表控制器
 * @Author ：lishixiang
 * @Date：2020/5/29-11:54
 * @Version:
 */
@RestController
@RequestMapping("/v1/staffDiagnose")
@Api(description = "员工指标")
public class StaffDiagnoseController extends BaseController{

    @Autowired
    private StaffDiagnoseService staffDiagnoseService;

    @ApiOperation(value = "员工指标 添加员工",notes = "List传值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value ="员工信息表单" ,dataType ="List<Integer>",paramType = "body"),
            @ApiImplicitParam(name = "token",value = "token",dataType = "String",paramType = "header")
            })
    @PostMapping("/join")
    public void addStaff(@Validated @RequestBody List<Long> ids){
        String token = getToken();
        staffDiagnoseService.joinStaff(ids,token );
    }
}
