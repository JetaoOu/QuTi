package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.myproject.pojo.user;

import redis.clients.jedis.Jedis;

public class redis {
	
	
	@Test
	public void redisTester() {
	    Jedis jedis = new Jedis("localhost", 6379, 100000);
	    int i = 0;
	    try {
	        long start = System.currentTimeMillis();// 开始毫秒数
	        while (true) {
	            long end = System.currentTimeMillis();
	            if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
	                break;
	            }
	            i++;
	            jedis.set("test" + i, i + "");
	        }
	    } finally {// 关闭连接
	        jedis.close();
	    }
	    // 打印1秒内对Redis的操作次数
	    System.out.println("redis每秒操作：" + i + "次");
	}
	
	
	@Test
	public void test() {
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-redis.xml");
	    RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
	    user user = new user();
	    user.setName("我是名字");
	    user.setUsername("我是用户名");
	    redisTemplate.opsForValue().set("user", user);
	    user student1 = (user) redisTemplate.opsForValue().get("user");
	    System.out.println("学生名字为：" + student1.getUsername());
        System.out.println("学生年龄为：" + student1.getName());
	}

}
