package com.huazhu.application.cms.common.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    private static final String redisCode = "utf-8";
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置某个键的过期时间
     *
     * @param key     键
     * @param expire  时间 单位秒
     * @param dbIndex redis库索引 0-15
     */
    private void expire(String key, Integer expire, int dbIndex) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);

    }

    /**
     * 设置某个键的过期时间
     *
     * @param key    键
     * @param expire 时间 单位秒
     */
    public void expire(String key, Long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);

    }

    /**
     * 添加键值对
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(key, value);

    }

    /**
     * 添加键值对 并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间 单位:秒
     */
    public void set(String key, String value, Long time) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(key, value, time, TimeUnit.SECONDS);

    }


    /**
     * 根据键查询值
     *
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        return stringStringValueOperations.get(key);

    }

    /**
     * 增长1  -->  count++;
     *
     * @param key 键
     * @return 值
     */
    public String incr(String key) {

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        Long increment = stringStringValueOperations.increment(key, 1L);
        return String.valueOf(increment);
    }

    public Long flexibleChange(String key, Integer num) {
        return redisTemplate.boundValueOps(key).increment(num);
    }


    /**
     * 判断某个值是否存在
     *
     * @param key 键
     * @return 是否存在
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除某个键值对
     *
     * @param key 键
     */
    public void del(String key) {
        redisTemplate.delete(key);

    }



}
