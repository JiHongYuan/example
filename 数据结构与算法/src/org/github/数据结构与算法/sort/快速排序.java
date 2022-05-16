package org.github.数据结构与算法.sort;

import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/7/18 9:47
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] ints = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6};
        quickSort(ints, 0, ints.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start;
        int r = end;

//        int pivot = median3(array, start, end - 1);
        int pivot = array[(start + end) / 2];
        while (true) {

            // 将 left指针 移动到 小于mid的元素上
            while (array[l] < pivot) {
                l++;
            }

            // 将 left指针 移动到 大于mid的元素上
            while (array[r] > pivot) {
                r--;
            }

            if (l < r) {
                swap(array, l, r);
            } else {
                break;
            }

            System.out.println(Arrays.toString(array));
        }

        if (array[l] > array[end - 1]) {
            swap(array, l, end - 1);
        }

        quickSort(array, start, l - 1);
        quickSort(array, l + 1, end);
    }

    public static int median3(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] > array[mid]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }

        return array[right - 1];
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
