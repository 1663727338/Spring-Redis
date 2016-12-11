package com.lgd.study.SpringRedis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

public class UserDaoSpi extends AbstractBaseRedisDao<String, User> implements UserDao {

	public boolean add(final User user) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				
				RedisSerializer<String> seriealizer = getSerializer();
				
				byte[] id = seriealizer.serialize(user.getId());
				byte[] name = seriealizer.serialize(user.getName());
				
				return connection.setNX(id, name);
			}
			
		});
		
		return result;
	}

}
