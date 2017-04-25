package cn.larry.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by fugz on 2016/8/3.
 */
@Aspect
@Component
public class AnotationSleepHelper {

    public AnotationSleepHelper(){}

    @Pointcut("execution(* *.sleep())")
    public void sleeppoint() {
    }

    @AfterReturning("sleeppoint()")
    public void afterReturning() {
        System.out.println("起来之后要穿衣服");
    }

    @Before("sleeppoint()")
    public void before() throws Throwable {
        System.out.println("睡觉之前要先洗脸");
    }

}
