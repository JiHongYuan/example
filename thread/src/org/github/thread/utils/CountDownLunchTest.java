package com.github.thread.t1.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author JiHongYuan
 * @date 2021/10/26 15:02
 */
public class CountDownLunchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = getThread();
        Thread thread2 = getThread();
        Thread thread3 = getThread();

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("222");
        countDownLatch.await();
        System.out.println("111");
    }

    public static Thread getThread() {
        return new Thread(() -> {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });
    }
}
