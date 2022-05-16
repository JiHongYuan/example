package com.github.thread.t1.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author JiHongYuan
 * @date 2021/10/26 19:48
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println("3333");
        });
        thread.start();
        System.out.println("1111");
        thread.interrupt();
        System.out.println("2222");
    }
}
