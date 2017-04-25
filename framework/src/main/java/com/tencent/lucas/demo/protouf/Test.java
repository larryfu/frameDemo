package com.tencent.lucas.demo.protouf;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Created by lucasfu on 2017/4/20.
 */
public class Test {

    public static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        ActivityMessage activityMessage = new ActivityMessage();
        activityMessage.setAmount(1);
        activityMessage.setGiftId(22);
        activityMessage.setAmount(123);
        activityMessage.setSendTime(LocalDateTime.now().getSecond());
        activityMessage.setGiftPrice(22);
        activityMessage.setReceiverUin(3600123);
        activityMessage.setSenderUin(5128312);
        activityMessage.setGiftName("美丽的");
        logger.error("proto:{}",activityMessage.toByteArray());
        System.out.println(activityMessage.toByteArray().length);
        logger.error("json:{}",new Gson().toJson(activityMessage));
        System.out.println(new Gson().toJson(activityMessage).getBytes().length);
    }
}
