package org.github.thread;

/**
 * @author JiHongYuan
 * @date 2021/4/6 16:24
 * <p>
 * wait只会释放持有的锁
 */
public class WaitTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadA get resourceA lock");
                synchronized (resourceB) {
                    System.out.println("threadA get resourceB lock");
                    System.out.println("threadA release resourceB lock");
                    try {
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resourceA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadB get resourceA lock");
                synchronized (resourceB) {
                    System.out.println("threadB get resourceB lock");
                    System.out.println("threadB release resourceB lock");
                    try {
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("main over");
    }
}
