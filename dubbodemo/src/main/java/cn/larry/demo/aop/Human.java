package cn.larry.demo.aop;

import org.springframework.stereotype.Component;

/**
 * Created by fugz on 2016/8/3.
 */
@Component
public class Human implements Sleepable {
    @Override
    public void sleep() throws InterruptedException {
        System.out.println("i am sleeping ");
        Thread.sleep(10000);
    }
}
