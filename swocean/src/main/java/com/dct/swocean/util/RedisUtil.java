package com.dct.swocean.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
/**
 * 
 * @author 周平，王少刚
 *
 */
@Configuration
public class RedisUtil {

	private static String host;
	private static int port;
	private static String password;

	/**
	 * 
	 * @param key：所要设置的主键
	 * @param value：所要设置的值
	 * @return：返回的是成功与否
	 */
	public static boolean set(String key, String value) {
		if (key.length() == 0 || key == "" || value.length() == 0
				|| value == "") {
			return false;
		}
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		jedis.set(key, value);
		jedis.close();
		return true;
	}

	/**
	 * 
	 * @param key：所要设置的主键
	 * @param value：所要设置的值
	 * @param seconds：主键过期的时间
	 * @return
	 */
	public static boolean set(String key, String value, int seconds) {
		if (key.length() == 0 || key == "" || value.length() == 0
				|| value == "") {
			return false;
		}
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		jedis.set(key, value);
		jedis.expire(key, seconds);
		jedis.close();
		return true;
	}

	/**
	 * @param key：根据主键进行取值
	 * @return：返回的是主键对应的值
	 */
	public static String get(String key) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		if (!RedisUtil.exists(key)) {
			jedis.close();
			return null;
		}
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	/**
	 * @param key:根据主键进行取值
	 * @param seconds:过期时间
	 * @return 返回的是主键对应的值
	 */
	public static String get(String key, int seconds) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		if (!RedisUtil.exists(key)) {
			jedis.close();
			return null;
		}
		String string = jedis.get(key);
		jedis.expire(key, seconds);
		jedis.close();
		return string;
	}

	/**
	 * @param hashName：hash表的名字
	 * @param hashKey：hash表里的key
	 * @return：返回的是主键对应的hash表里的值
	 */
	public static String get(String hashName, String hashKey) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		if (!jedis.hexists(hashName, hashKey)) {
			jedis.close();
			return null;
		}
		String string = jedis.hget(hashName, hashKey);
		jedis.close();
		return string;
	}

	/**
	 * 
	 * @param key：所要判断的主键的名字
	 * @return：对应的key是否存在
	 */
	public static boolean exists(String key) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		Boolean flag = jedis.exists(key);
		jedis.close();
		return flag;
	}

	/**
	 * 
	 * @param key：所要设置的key的名字
	 * @param seconds ：所要设置的时间
	 * @return：设置是否成功
	 */
	public static boolean expire(String key, int seconds) {
		if (key.length() == 0 && key == "") {
			return false;
		}
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		Long i = jedis.expire(key, seconds);
		jedis.close();
		return i == 1;
	}

	/**
	 * 
	 * @param key  所要删除的key的名字
	 * @return 成功则为1，否则为0
	 */
	public static Long delKey(String key) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		Long flag = jedis.del(key);
		jedis.close();
		// return jedis.del(key) + jedis.zrem("userCache~keys", key);
		return flag;
	}
	/**
	 * 
	 * @param hashName:hash表的名字
	 * @param hashKey:hash表里的key
	 * @return 成功则为1，否则为0
	 */
	public static Long delKey(String hashName,String hashKey) {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		Long flag = jedis.hdel(hashName, hashKey);
		jedis.close();
		return flag;
	}
	
	/**
	 * 删除所有的DB缓存
	 * @return 成功则为OK
	 */
	public static String delAllDB() {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		String string = jedis.flushAll();
		jedis.close();
		return string;
	}
	/**
	 * 删除当前的DB缓存
	 * @return 成功则为OK
	 */
	public static String delOneDB() {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(password);
		String string = jedis.flushDB();
		jedis.close();
		return string;
	}

	@Value("${spring.redis.host}")
	public void setHost(String host) {
		RedisUtil.host = host;
	}

	@Value("${spring.redis.port}")
	public void setPort(int port) {
		RedisUtil.port = port;
	}

	@Value("${spring.redis.password}")
	public void setPassword(String password) {
		RedisUtil.password = password;
	}

}
