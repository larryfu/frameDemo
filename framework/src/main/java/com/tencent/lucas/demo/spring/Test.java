package com.tencent.lucas.demo.spring;

import com.tencent.lucas.demo.mybatis.dal.EveningBonusPoolMapper;
import com.tencent.lucas.demo.mybatis.dal.UserEveningInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by lucasfu on 2016/12/30.
 */
public class Test {

    private static ExecutorService service = Executors.newFixedThreadPool(4);

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationcontext.xml");
        EveningBonusPoolMapper eveningBonusPoolMapper = (EveningBonusPoolMapper) context.getBean("eveningBonusPoolMapper");
        UserEveningInfoMapper userEveningInfoMapper = (UserEveningInfoMapper) context.getBean("userEveningInfoMapper");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","fu");
        eveningBonusPoolMapper.insertTest(map);
        System.out.println(map.get("id"));
        userEveningInfoMapper.updateFreeGift(1, 12311, 1);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int id = new Random().nextInt(100000);
//        service.submit(() -> {
//            try {
//                countDownLatch.await();
//                System.out.println("thread 1 execute" + System.nanoTime());
//                userEveningInfoMapper.insertUserInfo(id, 1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        service.submit(() -> {
//            try {
//                countDownLatch.await();
//                System.out.println("thread 2 execute" + System.nanoTime());
//                userEveningInfoMapper.insertUserInfo(id, 2);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        //countDownLatch.countDown();
        //Integer rounds = eveningBonusPoolMapper.getComputeRound();
        // System.out.println(rounds);
    }
}
