package com.kaysen.shop.redis.cache;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisCache {

	/**
	 * 批量插入key-value
	 * @param map
	 */
	public void mset(Map<String, Object> map);


	/**
	 * 批量获取keys的value值
	 * @param keys
	 * @return
	 */
	public List<Object> mget(List<String> keys) ;

	/**
	 * 单个key保存
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value) ;

	/**
	 * 单个key存储，且设置过期时间
	 * @param key
	 * @param value
	 * @param timeOut
	 */
	public void set(String key, Object value, long timeOut) ;

	/**
	 * 获取单个KEy的值
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * key重命名
	 * @param odlKey
	 * @param newKey
	 */
	public void rename(final String odlKey, final String newKey) ;


	/**
	 * 删除某个对象
	 * @param key
	 */
	public void remove(String key);

	/**
	 * 查询key是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) ;

	/**
	 * 设置key在某一个时刻（timeout）时效
	 * @param key
	 * @param timeout 失效的时间点
	 * @return
	 */
	public boolean expireAt(String key, Date timeout);

	/**
	 * 设置key的时效时间
	 * @param key
	 * @param timeout  24*7 一周
	 * @param unit 时间单位，天：TimeUnit.DAYS 小时TimeUnit.HOURS  秒：TimeUnit. SECONDS   毫秒：TimeUnit.MILLISECONDS  微秒：TimeUnit.MICROSECONDS  纳秒：TimeUnit.NANOSECONDS
	 * @return
	 */
	public boolean expire(String key, long timeout, TimeUnit unit);

	/**
	 * 根据正在表达式获取key
	 *
	 * @param pattern
	 * @return h?llo 匹配 hello, hallo 和 hxllo h*llo 匹配 hllo 和 heeeello h[ae]llo
	 *         匹配 hello 和 hallo, 但是不匹配 hillo h[^e]llo 匹配 hallo, hbllo, … 但是不匹配
	 *         hello h[a-b]llo 匹配 hallo 和 hbllo
	 */
	public Set<String> keys(String pattern);


	/**
	 * 返回key的数量
	 * @return
	 */
	public long dbSize() ;

	/**
	 * 如果后面没有参数时返回PONG，否则会返回后面带的参数。 这个命令经常用来测试一个连接是否还是可用的，或者用来测试一个连接的延时。
	 * 如果客户端处于频道订阅模式下，它将是一个multi-bulk返回，第一次时返回”pong”，之后返回空（empty bulk），除非命令后面更随了参数。
	 * @return
	 */
	public String ping();


	/**
	 * 储存MAP
	 * data = new HashMap<String, String>(); data.put("studentId",
	 * CommentUtils.convertNull(studentCount.getStudentId()));
	 * data.put("commentHeadCount",
	 * CommentUtils.convertLongToString(studentCount.getCommentHeadCount()));
	 * @param key
	 * @param objMap
	 */
	public void saveMapAll(final String key, final Map<String, Object> objMap);


	/**
	 * 保存或更新mapName中mapKey对应的value
	 * @param mapName map名称
	 * @param mapKey  map中的key值
	 * @param value
	 */

	public void saveMapKey(final String mapName, final String mapKey, final Object value) ;

	/**
	 * 获取MAP对象
	 */
	public Map<String,Object> hGetAll(String mapName);

	/**
	 * 获取MAP的某个key值
	 */
	public Object hGet(String mapName, String mapKey) ;

	/**
	 * 获取MAP的某几个key值，
	 * @param key规定以对象类名+ID的形式组成
	 */
	public Object hMget(String mapName, List<String> keys);

	
	public String flushDB();
}