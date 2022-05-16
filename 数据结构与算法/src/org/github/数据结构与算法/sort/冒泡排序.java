package org.github.数据结构与算法.sort;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/16 10:53
 */
public class 冒泡排序 {

    /**
     * 冒泡排序
     * 将最大值 循环交换到 数组尾部
     *
     * */
    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 3, 4, 1, 3, 89, 7, 4};

        int temp;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }

            System.out.println(Arrays.toString(array));
        }
    }
}
