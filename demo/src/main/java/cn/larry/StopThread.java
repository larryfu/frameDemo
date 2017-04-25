package cn.larry;

import java.util.concurrent.TimeUnit;

/**
 * Created by larryfu on 2016/3/10.
 *
 * @author larryfu
 */
public class StopThread {
    // Broken! - How long would you expect this program to run?

        private static  boolean stopRequested;
        public static void main(String[] args)
                throws InterruptedException {
            Thread backgroundThread = new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    while (!stopRequested){
                        i++;
                       // System.out.println(i);
                    }

                }
            });
            backgroundThread.start();
            TimeUnit.SECONDS.sleep(1);
            stopRequested = true;
        }

}
