package com.zkl.taishou.controller;

import com.zkl.taishou.service.CustomerConsumptionService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: 客户消费诊断
 * @Author ：lishixiang
 * @Date：2020/5/28-15:37
 * @Version:
 */
@RestController
@ResponseBody
public class CustomerConsumptionController extends BaseController {

    private CustomerConsumptionService customerConsumptionService;


}
