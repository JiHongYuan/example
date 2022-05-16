package com.github.thread.t1.local;

/**
 * @author JiHongYuan
 * @date 2021/9/11 13:03
 */
public class InheritableThreadLocalTest01 {
    public static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("main test");
        new Thread(() -> {
            while (true) {
                System.out.println(threadLocal.get());
                try {
                    Thread.sleep(1000);
                    threadLocal.set("thread:" + "child test01");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(3000);
        System.out.println("main:" + threadLocal.get());
        threadLocal.set("main:" + "main test01");
    }

}
