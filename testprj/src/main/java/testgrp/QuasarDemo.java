package testgrp;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.FiberForkJoinScheduler;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableCallable;
import co.paralleluniverse.strands.channels.Channels;
import co.paralleluniverse.strands.channels.IntChannel;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * run    mvn clean compile dependency:properties exec:exec
 * Created by lucasfu on 2017/5/25.
 */
public class QuasarDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FiberForkJoinScheduler scheduler = new FiberForkJoinScheduler("base", 8);
        AtomicInteger ai = new AtomicInteger(0);
        final IntChannel increasingToEcho = Channels.newIntChannel(0);

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Fiber<Void> fiber = new Fiber<>(scheduler, new SuspendableCallable<Void>() {
                @Override
                public Void run() throws SuspendExecution, InterruptedException {
                    int i = ai.getAndIncrement();
                    double r = random.nextDouble() / random.nextDouble();
                    System.out.println("fiber:" + i);
                    return null;
                }
            }).start();
            // fiber.join();
        }
        Thread.sleep(100000);


    }
}
