package cn.larry.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by fugz on 2016/8/3.
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    public void sleeppoint(){

    }


    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("起来之后要穿衣服");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("睡觉之前要先洗脸");
    }
}
