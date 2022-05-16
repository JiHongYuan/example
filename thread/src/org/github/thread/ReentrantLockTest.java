package org.github.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JiHongYuan
 * @date 2021/8/16 16:32
 */
public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        try{
            test.lock.lock();
            System.out.println(1111);
        }finally {
            test.lock.unlock();
        }
    }
}
