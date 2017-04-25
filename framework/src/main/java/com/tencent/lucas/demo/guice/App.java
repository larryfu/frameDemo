package com.tencent.lucas.demo.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * Created by lucasfu on 2016/8/25.
 */
public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new  AppModule());
    }
}
