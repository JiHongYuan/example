package org.github.thread;

/**
 * @author JiHongYuan
 * @date 2021/4/6 16:50
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> threadLocal.set(123));

        threadA.start();
        threadA.join();
        threadLocal.get();
    }
}
