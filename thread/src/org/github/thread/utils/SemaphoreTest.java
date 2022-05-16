package com.github.thread.t1.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

/**
 * @author JiHongYuan
 * @date 2021/10/26 15:20
 */
public class SemaphoreTest {
    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = getThread();
            threads[i].start();
        }

    }

    public static Thread getThread() {
        return new Thread(() -> {
            try {
                semaphore.acquire();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ":获取到资源");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });
    }
}
