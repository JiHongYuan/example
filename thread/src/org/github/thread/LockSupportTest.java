package org.github.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author JiHongYuan
 * @date 2021/4/7 16:27
 */
public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread start");

            while (!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }
            System.out.println("child thread end");
        });

        thread.start();

        Thread.sleep(1000);
        thread.wait();

        System.out.println("main start");
        thread.interrupt();
        System.out.println("main end");
    }
}
