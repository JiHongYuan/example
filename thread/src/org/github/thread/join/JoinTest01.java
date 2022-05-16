package com.github.thread.t1.join;

/**
 * @author JiHongYuan
 * @date 2021/9/11 12:07
 */
public class JoinTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait");

        System.out.println("thread one before");
        threadOne.join();
        System.out.println("thread one after");

        System.out.println("thread two before");
        threadTwo.join();
        threadTwo.interrupted();
        System.out.println("thread two after");
    }
}
