package com.kaysen.shop.redis.cache.impl;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 自定义shiro缓存工厂类
 * @author zhangsong
 * @2016年6月1日
 */
@Component
public class ShiroCacheManager  implements org.apache.shiro.cache.CacheManager{

	@Resource(name="shiroCacheImpl")
	private Cache cache;

	@Override
	/**
	 * 获取缓存实现对象
	 */
	public <K, V> Cache<K, V> getCache(String arg0) throws CacheException {
		return cache;
	}
}
