package com.cn.zhou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedis {
	public static void main(String[] args) {
//		testJedis();
		testJedisPool2();
	}
	
	
	public static void testJedis() {
		//创建一个Jedis的连接
		Jedis jedis = new Jedis("192.168.44.115", 6379);
		//执行redis命令
		jedis.set("mytest", "hello world, this is jedis client!");
		//从redis中取值
		String result = jedis.get("mytest");
		//打印结果
		System.out.println(result);
		//关闭连接
		jedis.close();
		
	}
	public static void testJedisPool() {
		//创建一连接池对象
		JedisPool jedisPool = new JedisPool("192.168.44.115", 6379);
		//从连接池中获得连接
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("mytest");
		System.out.println(result);
		//关闭连接
		jedis.close();
		//关闭连接池
		jedisPool.destroy();
//		jedisPool.close();
	}
	
	public static void testJedisPool2() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spirng-mvc.xml");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resource/spirng-mvc.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");
		Jedis jedis = null;
		try {
			jedis = pool.getResource();

			jedis.set("name", "lisi");
			String name = jedis.get("name");
			System.out.println(name);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (jedis != null) {
				// 关闭连接
				jedis.close();
			}
		}
	}
}
