package org.github.数据结构与算法.queue;

/**
 * @author JiHongYuan
 * @date 2021/8/24 22:09
 */
public class MyCircularQueue {
    int max;
    int front, rear, size;
    int[] queue;

    public MyCircularQueue(int k) {
        queue = new int[k];
        max = k;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        queue[rear] = value;
        rear = (rear + 1) % max;
        size++;
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真。
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % max;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[(front + size - 1 ) % max];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void show() {
        for (int i = front; i < front + size; i++) {
            System.out.printf("%d\t", queue[i % max]);
        }
        System.out.println();
    }
}
