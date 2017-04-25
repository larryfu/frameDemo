package com.tencent.lucas.demo;

import java.util.Date;
import java.util.Random;

/**
 * Created by lucasfu on 2017/1/6.
 */
public class Test {

    public static void main(String[] args) {
        long seed = new Date().getTime();
        Random random = new Random(seed);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
        System.out.println("***************************");
        Random random1 = new Random(seed);
        for (int i = 0; i < 10; i++) {
            System.out.println(random1.nextInt());
        }
    }
}
