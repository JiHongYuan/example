package org.github.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author JiHongYuan
 * @date 2021/8/16 16:59
 */
public class ReentrantReadWriteLockTest {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        readLock.unlock();
    }
}
