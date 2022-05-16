package com.github.thread.t1.lock;

/**
 * @author JiHongYuan
 * @date 2021/10/27 10:42
 */
public class MyReentrantLock {
    static int state = 1622200000;

    public static void main(String[] args) {
        System.out.println(state >>> (1 << 16) - 1);
        System.out.println(state & (1 << 16) - 1);
    }
}
