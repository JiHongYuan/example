package org.github.数据结构与算法.heap.binary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JiHongYuan
 * @date 2021/6/20 13:04
 */
public class BinaryHeapTest {

    static class BinaryHeap {
        int capacity;
        int size;
        Integer[] elementData;

        public BinaryHeap(int size) {
            initialize(size);
        }

        public void initialize(int size) {
            this.capacity = size;
            this.size = 0;
            this.elementData = new Integer[size];
            // 标记，这个值必须保证小于堆中任何值
            this.elementData[0] = 0;
        }

        /**
         * elementData[0] is a sentinel
         */
        public void insert(int val) {
            int i;
            for (i = ++size; elementData[i / 2] > val; i = i / 2) {
                elementData[i] = elementData[i / 2];
            }
            elementData[i] = val;
        }

        public void deleteMin() {
            int lastElement = elementData[size--];

            int i, child = 0;
            for (i = 1; i * 2 <= size; i = child) {
                child = i * 2;

                // 1. 防止越界
                // 2. 比较左右节点大小，如果右节点大，child指针移动到右节点
                if (child != size && (elementData[child + 1] < elementData[child])) {
                    child++;
                }

                // 最小的子节点 和 父节点 交换
                if (lastElement > elementData[child]) {
                    elementData[i] = elementData[child];
                } else {
                    break;
                }
            }

            elementData[i] = lastElement;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elementData, size + 1));
        }

    }


    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(12);
        for (Integer integer : new Integer[]{13, 21, 16, 24, 31, 19, 68, 65, 26, 32, 14}) {
            binaryHeap.insert(integer);
        }
        System.out.println(binaryHeap.toString());
        binaryHeap.deleteMin();
        System.out.println(binaryHeap.toString());
    }
}
