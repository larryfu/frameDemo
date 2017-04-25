package cn.larry.demo.dubbo.consumer;

import cn.larry.demo.dubbo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fugz on 2016/4/12.
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer-context.xml");
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println( hello ); // 显示调用结果
    }

}
