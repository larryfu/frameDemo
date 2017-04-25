package cn.larry.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fugz on 2016/8/3.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/aop1-context.xml");
        Sleepable sleepable = (Sleepable) applicationContext.getBean("human");
        sleepable.sleep();
    }
}
