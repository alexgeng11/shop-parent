package com.kaysen.shop.redis.cache.impl;

import com.kaysen.shop.redis.cache.RedisDAO;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * shiro缓存类
 * @author zhangsong
 * @param <K>
 * @param <V>
 */
public class ShiroCacheImpl<K,V> implements Cache<K,V> {

	@Resource
	RedisDAO redisDAO;
	private Integer timeout=60*60 ;//超时时间，单位为秒

	@Override
	public void clear() throws CacheException {
	}

	@Override
	public V get(K key) throws CacheException {
		String s = redisDAO.get(key.toString());
		return (V) s;
	}

	@Override
	public Set<K> keys() {
		return null;
	}

	@Override
	public V put(K key, V value) throws CacheException {
		redisDAO.set(key.toString(), value.toString(),timeout);
		return get(key);
	}

	@Override
	public V remove(K key) throws CacheException {
		redisDAO.delete(key.toString());
		return null;
	}

	@Override
	public int size() {
		return redisDAO.dbSize().intValue();
	}

	@Override
	public Collection<V> values() {
		return null;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}


}
