package com.taishou.console.service;

import com.taishou.console.common.entity.Administrator;
import com.taishou.console.common.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * redis服务接口
 *
 * @author LiShiXiang
 */
@Service("redisService")
public interface RedisService {

    /**
     * 用户登录
     */
    public String userLogin(User user, int timeout);

    /**
     * 后台管理员登录
     */
    public String userLogin(Administrator admin, int timeout);


    /**
     * 设置单个对象信息
     *
     * @param key
     * @param value
     * @author LiShiXiang
     */
    public void set(String key, Object value);

    /**
     * 设置map
     *
     * @param key
     * @param value
     * @author LiShiXiang
     */
    public void setObject(String key, Object value);

    /**
     * 设置单个对象信息
     * 有超时时间
     *
     * @param key
     * @param value
     * @param timeout 0=不超时
     * @author LiShiXiang
     */
    public void set(String key, Object value, int timeout);

    /**
     * 根据key获取对象信息
     *
     * @param key
     * @return
     * @author LiShiXiang
     */
    public String get(String key);

    /**
     * 根据key获取对象信息
     *
     * @param key
     * @return
     * @author LiShiXiang
     */
    public Object getObject(String key);

    /**
     * 根据key删除数据信息
     *
     * @param key
     * @author LiShiXiang
     */
    void delete(String key);


    void remove(String key);

    /**
     * 检验一个key是否存在  true为存在
     * @param key
     * @author LiShiXiang
     */
    boolean exists(String key);

    /**
     * 用户登录
     */
   // public String userLogin(UserInfo user, int timeout);

    /**
     * 更新存储时间
     * @param key
     * @param time
     */
    void setPastDueTime(String key, int time);


    /**
     * 添加消息
     * @param queueKey
     * @param param
     */
    void addMessage(String queueKey, String param);

    /**
     * 获取hash内容
     * @param key
     * @param name
     * @return
     */
    Optional<String> getResultFromHash(String key, Object name);

    /**
     * 保存内容到HASH
     * @param key
     * @param name
     * @param value
     * @param timeout
     * @param unit
     * @return
     */
    boolean putResultToHash(String key, Object name, String value, long timeout, TimeUnit unit);

    /**
     * 保存内容到HASH ; 默认7天
     * @param key
     * @param name
     * @param value
     * @return
     */
    boolean putResultToHash(String key, Object name, String value);

}
