package com.kaysen.shop.redis.cache;

/**
 * @Classname RedisDAO
 * @Description TODO
 * @Date 2019/8/9 15:33
 * @Created by ks.xu
 */
public interface RedisDAO {
    public void set(String key, String value);
    public String get(String key);
    Long delete(String key);

    Long dbSize();
    void set(String key, String value,Integer time);
}
