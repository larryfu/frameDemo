package cn.larry.demo.dubbo.provider;

import cn.larry.demo.dubbo.DemoService;

/**
 * Created by fugz on 2016/4/12.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "hello "+name+" ! ";
    }
}
