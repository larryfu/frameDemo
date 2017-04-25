package com.tencent.lucas.demo.spring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lucasfu on 2017/2/5.
 */
public class ExecuterTest {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                throw new RuntimeException("exit");
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                throw new RuntimeException("exit");
            }
        });

        Thread.sleep(1000);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println("execute");
            }
        });
    }
}
