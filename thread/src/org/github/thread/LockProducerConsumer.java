package org.github.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JiHongYuan
 * @date 2021/9/9 10:57
 */
public class LockProducerConsumer {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[]{
                true, true, false, false, true, false, false, true, true
        };
        long startTime = System.currentTimeMillis();

        for (int i = 0; i <= 999999999; i++) {
            int index = i % (booleans.length - 1);

            for(int k = 0; k < 20; k++){
                boolean aBoolean = booleans[index] || booleans[index + 1];
                aBoolean = booleans[index + 1] || booleans[index];
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

}
