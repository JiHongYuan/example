package org.github.数据结构与算法.queue;


/**
 * @author JiHongYuan
 * @date 2021/6/15 16:38
 */
public class CircularArrayQueue {

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(6);


        System.out.println(queue.enQueue(6));
        System.out.println(queue.enQueue(0));
        System.out.println(queue.enQueue(0));
        System.out.println(queue.enQueue(0));
        System.out.println(queue.enQueue(5));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());


        System.out.println(9 );
    }
}
