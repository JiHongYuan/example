package org.github.数据结构与算法.sort;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/17 9:25
 */
public class 希尔排序 {
    public static void main(String[] args) {
        shellSort2(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0});
    }



    public static void shellSort2(int[] array) {
        int gap;

        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {

                if (array[i] < array[i - gap]) {
                    int index = i;
                    int temp = array[i];
                    while (index - gap >= 0 && temp < array[index - gap]) {
                        array[index] = array[index - gap];
                        index -= gap;
                    }
                    array[index] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
