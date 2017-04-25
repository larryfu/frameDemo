package cn.larry.demo.redis;


import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by fugz on 2016/4/12.
 */
public class TestRedis {

    private Jedis jedis;

    @Before
    public void setup() {
        jedis = new Jedis("120.76.146.233", 6379);
        //权限认证
        //jedis.auth("admin");
    }

    @Test
    public void testJedis() {
        jedis.set("name", "larryfu");
        jedis.set("name", "larry");
        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age");
        System.out.println(jedis.get("age"));
    }

    @Test
    public void testSetGet() {
        jedis.sadd("abc123", "as");
        System.out.println("set ");
        jedis.get("abc123");
    }

    /**
     * redis存储字符串
     */
    @Test
    public void testString() {

        jedis.set("name", "xinxin");
        System.out.println(jedis.get("name"));

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");
        System.out.println(jedis.get("name"));

        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age");
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user", map);

        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);

        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList() {
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));

        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet() {
        //添加
        jedis.sadd("username", "liuling");
        jedis.sadd("username", "xinxin");
        jedis.sadd("username", "ling");
        jedis.sadd("username", "zhangxinxin");
        jedis.sadd("username", "ling");
        jedis.sadd("username", "who");
        //移除noname
        jedis.srem("username", "who");
        System.out.println(jedis.smembers("username"));//获取所有加入的value
        System.out.println(jedis.sismember("username", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("username"));
        System.out.println(jedis.scard("username"));//返回集合的元素个数
    }

    @Test
    public void test() throws InterruptedException {
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    @Test
    public void testRedisPool() {
        RedisUtil.getJedis().set("newname", "中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
}
