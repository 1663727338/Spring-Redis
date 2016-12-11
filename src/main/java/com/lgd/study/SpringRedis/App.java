package com.lgd.study.SpringRedis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	static UserDao userDao;
	
    public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		App.userDao = userDao;
	}

	public static void main( String[] args )
    {
		new ClassPathXmlApplicationContext("redis.spring.xml");
    	User user = new User();
    	user.setId("4");
    	user.setName("lgd");
    	
    	
    	boolean result = userDao.add(user);
        System.out.println( "Result is " + result);
    }
}
