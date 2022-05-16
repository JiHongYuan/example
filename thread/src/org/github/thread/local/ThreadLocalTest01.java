package com.github.thread.t1.local;

/**
 * @author JiHongYuan
 * @date 2021/9/11 12:42
 */
public class ThreadLocalTest01 {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("test");
        String s = threadLocal.get();
        System.out.println(s);
    }

}
