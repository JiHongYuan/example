package com.github.thread.t1.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author JiHongYuan
 * @date 2021/9/11 11:50
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello thread call";
    }

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new CallerTask());

        new Thread(task).start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
