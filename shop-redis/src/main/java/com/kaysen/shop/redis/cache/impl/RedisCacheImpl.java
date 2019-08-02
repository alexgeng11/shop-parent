package com.kaysen.shop.redis.cache.impl;

import com.kaysen.shop.redis.cache.RedisCache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * redis缓存 操作工具类
 * @author zhangsong
 * @2016年5月18日
 */
@Repository("redisCache")
public class RedisCacheImpl implements RedisCache {

	@Resource
    RedisTemplate redis;

	/**
	 * 批量插入key，会替换已经存在key的value，三种方式批量插入：mset  pinpile管道   lua表达式
	 * @param map key：对应的reids的key， value：对应每个key的value
	 * 示例：MSET key1 "Hello" key2 "World
	 */
	@Override
	public void mset(Map<String,Object> map){
		ValueOperations<String, Object> ops=redis.opsForValue();
		ops.multiSet(map);
	}

	/**
	 * 批量获取key
	 * @param keys
	 * @return
	 */
	@Override
	public List<Object> mget(List<String> keys){
		ValueOperations<String, Object> ops=redis.opsForValue();
		return ops.multiGet(keys);
	}
	
	/**
	 * 单个key存储， 注意：批量插入请尽量使用mset方法，否则效率非常低，而且事务不好处理
	 * 
	 */
	@Override
	public void set(String key, Object value) {
		ValueOperations<String, Object> valueOper=redis.opsForValue();
		valueOper.set(key, value);
	}
	
	/**
	 * 单个key存储，且设置过期时间 
	 * @param key
	 * @param value 
	 * @param timeOut 过期时间 单位：s
	 */
	@Override
	public void set(String key, Object value, long timeOut) {
		ValueOperations<String, Object> valueOper=redis.opsForValue();
		valueOper.set(key, value, timeOut,TimeUnit.SECONDS);
	}

	@Override
	public Object get(String key) {
		ValueOperations<String, Object> ops=redis.opsForValue();
		return ops.get(key);
	}
	
	/**
	 * key重命名
	 * @param odlKey
	 * @param newKey
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void rename(final String odlKey, final String newKey) {
		redis.rename(odlKey, newKey);
//		redis.execute(new RedisCallback<Serializable>() {
//			@Override
//			public Serializable doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<Serializable> value = (RedisSerializer<Serializable>) redis.getValueSerializer();
//				connection.rename(value.serialize(odlKey), value.serialize(newKey));
//				return null;
//			}
//		});
	}

	@Override
	public void remove(String key) {
		redis.delete(key);
		
	}
	
	/**
	 * 查询key是否存在
	 * @param key
	 * @return
	 */
	@Override
	public boolean exists(final String key) {
		return redis.hasKey(key);
//		return (boolean) redis.execute(new RedisCallback() {
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				return connection.exists(key.getBytes());
//			}
//		});
	}

	/**
	 * 设置key在某一个时刻（timeout）时效
	 * @param key
	 * @param timeout 失效的时间点
	 * @return
	 */
	@Override
	public boolean expireAt(String key, Date timeout){
		return redis.expireAt(key, timeout);
	}
	
	/**
	 * 设置key的时效时间
	 * @param key
	 * @param timeout  24*7 一周
	 * @param unit 时间单位，天：TimeUnit.DAYS 小时TimeUnit.HOURS  秒：TimeUnit. SECONDS   毫秒：TimeUnit.MILLISECONDS  微秒：TimeUnit.MICROSECONDS  纳秒：TimeUnit.NANOSECONDS
	 * @return
	 */
	@Override
	public boolean expire(String key, long timeout, TimeUnit unit){
		return redis.expire(key, timeout, unit);
	}
	
	/**
	 * 获取key的有效时间，单位是seconds
	 * @param key
	 */
	public Long getExpire(String key){
		return redis.getExpire(key);
	}
	/**
	 * 根据正在表达式获取key
	 * 
	 * @param pattern
	 * @return h?llo 匹配 hello, hallo 和 hxllo h*llo 匹配 hllo 和 heeeello h[ae]llo
	 *         匹配 hello 和 hallo, 但是不匹配 hillo h[^e]llo 匹配 hallo, hbllo, … 但是不匹配
	 *         hello h[a-b]llo 匹配 hallo 和 hbllo
	 */
	@Override
	public Set<String> keys(String pattern) {
		return redis.keys(pattern);

	}

	/**
	 * 返回key的数量
	 * @return
	 */
	@Override
	public long dbSize() {
		return (long) redis.execute(new RedisCallback() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.dbSize();
			}
		});
	}

	/**
	 * 如果后面没有参数时返回PONG，否则会返回后面带的参数。 这个命令经常用来测试一个连接是否还是可用的，或者用来测试一个连接的延时。
	 * 如果客户端处于频道订阅模式下，它将是一个multi-bulk返回，第一次时返回”pong”，之后返回空（empty bulk），除非命令后面更随了参数。
	 * @return
	 */
	@Override
	public String ping() {
		return (String) redis.execute(new RedisCallback() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.ping();
			}
		});
	}


	/**
	 * 储存MAP，
	 * data = new HashMap<String, String>(); data.put("studentId",
	 * CommentUtils.convertNull(studentCount.getStudentId()));
	 * data.put("commentHeadCount",
	 * CommentUtils.convertLongToString(studentCount.getCommentHeadCount()));
	 * @param key
	 * @param objMap 需要存储的map对象
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void saveMapAll(String key, Map objMap){
		BoundHashOperations<String, String, String> ops = redis.boundHashOps(key);
		ops.putAll(objMap);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void saveMapKey(String mapName,String mapKey,Object value){
		BoundHashOperations<String, String, Object> ops = redis.boundHashOps(mapName);
		ops.put(mapKey, value);
	}
	
	/**
	 * 获取整个MAP，包括key与value，
	 * @param key 规定以对象类名+ID的形式组成
	 */
	@Override
	public Map<String,Object> hGetAll(String key) {
		BoundHashOperations<String, String, Object> ops = redis.boundHashOps(key);
		return ops.entries();
	}
	/**
	 * 获取MAP的某个key值
	 * @param key 规定以对象类名+ID的形式组成
	 */
	@Override
	public Object hGet(String key, String mapKey) {
		BoundHashOperations<String, String, Object> ops = redis.boundHashOps(key);
		return ops.get(mapKey);
	}
	
	/**
	 * 获取MAP的某几个key值，
	 * @param key 规定以对象类名+ID的形式组成
	 */
	@Override
	public Object hMget(final String key, List<String> keys) {
		BoundHashOperations<String, String, Object> ops = redis.boundHashOps(key);
		return ops.multiGet(keys);
	}

	
	/**
	 * 清空当前数据库所有数据，
	 * 
	 * @return
	 * 
	 * 		public String flushDB() { return (String) redis.execute(new
	 *         RedisCallback() { public String doInRedis(RedisConnection
	 *         connection) throws DataAccessException { connection.flushDb();
	 *         return "ok"; } }); }
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String flushDB() {
		return (String) redis.execute(new RedisCallback() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}
}

