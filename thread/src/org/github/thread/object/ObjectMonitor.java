package com.github.thread.t1.object;

/**
 * @author JiHongYuan
 * @date 2021/9/11 11:56
 */
public class ObjectMonitor {

    public static void main(String[] args) {
        ObjectMonitor objectMonitor = new ObjectMonitor();
        try {
            objectMonitor.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
