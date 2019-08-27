package com.kaysen.shop.redis.cache.impl;

import com.kaysen.shop.redis.cache.RedisDAO;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {

    @Resource
    private JedisCluster jedisCluster;
    
    @Override
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }
    @Override
    public void set(String key, String value,Integer time) {
        jedisCluster.set(key, value);
        jedisCluster.expire(key,time);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Long delete(String key) {
        return  jedisCluster.del(key);
    }

    @Override
    public Long dbSize() {
        return jedisCluster.dbSize();
    }

}