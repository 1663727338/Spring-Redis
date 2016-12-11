package com.lgd.study.SpringRedis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class AbstractBaseRedisDao<K, V> {

	protected RedisTemplate<K, V> redisTemplate;

	public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	protected RedisSerializer<String> getSerializer()	
	{
		return redisTemplate.getStringSerializer();
	}

}
