package org.github.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author JiHongYuan
 * @date 2021/9/9 10:45
 */
public class SynchronizedProducerConsumer {

    public Queue<Integer> queue = new ArrayDeque<>(10);

    public synchronized Integer take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        Integer val = queue.poll();
        notifyAll();
        return val;
    }

    public synchronized void put(int val) throws InterruptedException {
        while (queue.size() == 10) {
            wait();
        }
        queue.add(val);
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedProducerConsumer main = new SynchronizedProducerConsumer();
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("消费者：" + main.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    Random random = new Random();
                    int i = random.nextInt();
                    main.put(i);
                    System.out.println("生产者：" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }


}
