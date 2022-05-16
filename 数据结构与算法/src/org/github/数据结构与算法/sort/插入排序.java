package org.github.数据结构与算法.sort;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/16 15:38
 */
public class 插入排序 {
    public static void main(String[] args) {
        // [1, 3, 3, 4, 4, 4, 7, 9, 89]
        int[] array = new int[]{9, 4, 3, 4, 1, 3, 89, 7, 4};
        insertSort(array);
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int insertIndex = i - 1;


            for (; insertIndex >= 0 && insertValue < array[insertIndex]; insertIndex--) {
                array[insertIndex + 1] = array[insertIndex];
            }
            // 目的 将 < insertValue的元素 往后推一个距离
//            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
//
//                insertIndex--;
//            }

            // + 1 将退出while条件的 -- 补上
            // 把insertValue和array 推进的位置放上去
            array[insertIndex + 1] = insertValue;
        }

        System.out.println(Arrays.toString(array));
    }
}
