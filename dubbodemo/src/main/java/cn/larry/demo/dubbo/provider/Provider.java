package cn.larry.demo.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fugz on 2016/4/12.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/provider-context.xml");
        context.start();

        System.in.read(); // 按任意键退出
    }
}
