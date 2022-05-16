package com.github.thread.t1.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author JiHongYuan
 * @date 2021/10/26 15:08
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = getThread();
            threads[i].start();
        }

    }

    public static Thread getThread() {
        return new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + "到达集合点");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + "开始工作");
        });
    }
}
