package org.github.数据结构与算法.sort;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/16 11:04
 */
public class 选择排序 {

    /**
     * 选择排序
     *
     * 循环将最小值 交换到 数组前部
     */
    public static void main(String[] args) {
        // [1, 3, 3, 4, 4, 4, 7, 9, 89]
        int[] array = new int[]{9, 4, 3, 4, 1, 3, 89, 7, 4};

        for (int i = 0; i < array.length; i++) {
            int index = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }

            if (index != i) {
                array[index] = array[i];
                array[i] = min;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
