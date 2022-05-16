package com.github.thread.t1.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JiHongYuan
 * @date 2021/10/26 15:29
 */
public class CachedExecutorTest {

    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

    }
}
