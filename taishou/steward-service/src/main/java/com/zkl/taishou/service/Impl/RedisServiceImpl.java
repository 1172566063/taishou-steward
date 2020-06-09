package com.zkl.taishou.service.Impl;


import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.user.User;
import com.zkl.taishou.common.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.zkl.taishou.service.RedisService;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@SuppressWarnings({"rawtypes", "unchecked"})
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String userLogin(User user, int timeout) {
        String randomToken = createToken(); //创建登录token
        String userJson = JSON.toJSONString(user);
        removeUserToken(user.getPhone());
        set(RedisKeyConstants.LOGIN_USER+user.getPhone(),randomToken,timeout);
        set(RedisKeyConstants.LOGIN_USER+randomToken,userJson,timeout);
        return randomToken;
    }

    /**
     * 根据userId删除之前的token与用户信息
     * @param phone
     */
    protected void removeUserToken(String phone){
        String token=get(RedisKeyConstants.LOGIN_USER+phone);
        delete(RedisKeyConstants.LOGIN_USER+token);
    }

    @Override
    public void set(String key, Object value) {
        set(key, value, 0);
    }

    @Override
    public void set(String key, Object value, int timeout) {
        String jsonValue ;
        if (value instanceof String) {
            jsonValue = (String) value;
        } else {
            jsonValue = JSON.toJSONString(value);
        }
        stringRedisTemplate.opsForValue().set(key, jsonValue);
        if (timeout > 0) { // 超时时间大于0 设置超时时间
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getObject(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.boundValueOps(key).get()!=null;
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 创建token
     *
     * @return
     */
    private String createToken() {
        return EncryptUtil.MD5(EncryptUtil.SHA(UUID.randomUUID().toString() + new Random().nextInt(100000)));
    }

    @Override
    public void setPastDueTime(String key,int time) {
        if(time>0){
            stringRedisTemplate.expire(key,time, TimeUnit.SECONDS);
        }
    }

    @Override
    public void addMessage(String queueKey, String param) {
        redisTemplate.convertAndSend(queueKey,param);
    }
}
