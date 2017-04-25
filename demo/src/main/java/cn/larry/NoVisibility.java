package cn.larry;

import java.util.concurrent.TimeUnit;

/**
 * Created by larryfu on 2016/3/10.
 *
 * @author larryfu
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
               Thread.yield();
            System.out.println(number);
        }
    }

    public static void mains(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0;i<1000;i++)
            mains(new String[]{});
    }
}
