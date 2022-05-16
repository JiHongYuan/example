package org.github.数据结构与算法.recursive;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/15 11:20
 */
public class 八皇后算法 {

    private static final int MAX = 8;
    private static int[] array = new int[MAX];
    private static int count;

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }


    public static void check(int n) {
        if (n == MAX) {
            System.out.println(Arrays.toString(array));
            count++;
            return;
        }

        for (int i = 0; i < MAX; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 1. 判断不能同列
            // 2. 判断不能对角线 直角三角形等边必须相等才是对角线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }

        return true;
    }
}
