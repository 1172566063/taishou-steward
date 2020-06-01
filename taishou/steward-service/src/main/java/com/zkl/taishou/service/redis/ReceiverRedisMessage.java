package com.zkl.taishou.service.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zkl.taishou.common.constants.MethodNames;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.common.entity.user.UserOperationRecord;
import com.zkl.taishou.dao.user.UserOperationRecordDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/31-15:27
 * @Version:
 */
public class ReceiverRedisMessage {

    private CountDownLatch latch;

    @Autowired
    RedisService redisService;

    @Autowired
    UserOperationRecordDAO userOperationRecordDAO;

    @Autowired
    public ReceiverRedisMessage(CountDownLatch latch) {
        this.latch = latch;
    }


    /**
     * 功能描述：用户操作记录
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/6/1 9:19
     */
    public void recordUserOperation(String jsonMsg) {
        JSONObject jsonObject = JSON.parseObject(jsonMsg);
        String method = jsonObject.getString("operation");// 获得目标方法名
        String token = jsonObject.getString("token");
        String operation = MethodNames.getValueByKey(method);
        if(StringUtils.isNotBlank(operation)) {
            String jsonString = redisService.get(RedisKeyConstants.LOGIN_USER + token);
            User user = JSONObject.parseObject(jsonString, User.class);
            UserOperationRecord userOperationRecord=new UserOperationRecord();
            userOperationRecord.setCreateTime(new Date());
            userOperationRecord.setUserPhone(user.getPhone());
            userOperationRecord.setOperation(operation);
            userOperationRecordDAO.insertSelective(userOperationRecord);
        }
        latch.countDown();
    }


}
