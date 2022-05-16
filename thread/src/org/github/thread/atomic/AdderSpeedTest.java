package com.github.thread.t1.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author JiHongYuan
 * @date 2021/9/12 13:15
 */
public class AdderSpeedTest {
    public static final Integer MAX_SIZE = 100000000;
    public static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            AdderAddThread atomicAddThread = new AdderAddThread();
            threads.add(atomicAddThread);
            atomicAddThread.start();
        }


        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - startTime);
    }

    static class AdderAddThread extends Thread {
        @Override
        public void run() {
            while (true) {
                longAdder.add(1L);
                if (longAdder.sum() >= MAX_SIZE) {

                    return;
                }
            }
        }
    }
}
