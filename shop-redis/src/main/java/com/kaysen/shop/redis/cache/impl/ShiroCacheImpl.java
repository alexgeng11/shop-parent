package com.kaysen.shop.redis.cache.impl;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * shiro缓存类
 * @author zhangsong
 * @param <K>
 * @param <V>
 */
public class ShiroCacheImpl<K,V> implements Cache<K,V> {

	@Resource
    RedisTemplate<K, V> redis;

	private Integer timeout ;//超时时间，单位为小时  修改By：zhangsong20160621

	@Override
	public void clear() throws CacheException {
	}

	@Override
	public V get(K key) throws CacheException {
		ValueOperations<K, V> ops=redis.opsForValue();
		return ops.get(key);
	}

	@Override
	public Set<K> keys() {
		return null;
	}

	@Override
	public V put(K key, V value) throws CacheException {
		ValueOperations<K, V> valueOper=redis.opsForValue();
		valueOper.set(key, value, timeout,TimeUnit.HOURS);
		return get(key);
	}

	@Override
	public V remove(K key) throws CacheException {
		redis.delete(key);
		return null;
	}

	@Override
	public int size() {
		return (int) redis.execute(new RedisCallback() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.dbSize();
			}
		});
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
