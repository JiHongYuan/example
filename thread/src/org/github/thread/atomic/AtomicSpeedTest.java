package com.github.thread.t1.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JiHongYuan
 * @date 2021/9/12 12:59
 */
public class AtomicSpeedTest {
    public static final Integer MAX_SIZE = 100000000;
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            AtomicAddThread atomicAddThread = new AtomicAddThread();
            threads.add(atomicAddThread);
        }

        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - startTime);
    }

    static class AtomicAddThread extends Thread {
        @Override
        public void run() {
            while (true) {
                int i = atomicInteger.incrementAndGet();
                if (i >= MAX_SIZE) {

                    return;
                }
            }
        }
    }
}
