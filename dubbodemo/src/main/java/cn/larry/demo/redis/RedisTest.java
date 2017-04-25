package cn.larry.demo.redis;

import cn.larry.demo.Utils.RandomUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by fugz on 2016/7/26.
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.31.105.12");
        System.out.println(jedis.keys("*"));
        jedis.set("name", "larry");
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationcontext.xml");
        JedisPool pool = (JedisPool) context.getBean("jedisPool");
        System.out.println(pool.getResource().keys("*"));
        ShardedJedisPool shardedJedisPool = (ShardedJedisPool) context.getBean("shardedJedisPool");
        ShardedJedis sjedis = shardedJedisPool.getResource();
        for (int i = 0; i < 10000; i++) {
            String str = RandomUtils.getString(5);
            sjedis.set(str, str);
        }
        sjedis.close();
    }
}
