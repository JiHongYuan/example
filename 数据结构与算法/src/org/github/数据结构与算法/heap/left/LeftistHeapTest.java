package org.github.数据结构与算法.heap.left;

/**
 * @author JiHongYuan
 * @date 2021/6/27 20:22
 */
public class LeftistHeapTest {
    public static void main(String[] args) {
        LeftistHeap h1 = new LeftistHeap();
        LeftistHeap h2 = new LeftistHeap();


        h1.builderTree(3, 10, 8, 21, 14, 17, 23, 26);
        h2.builderTree(6, 12, 7, 18, 24, 37, 18, 33);

        h1.printTree();
        System.out.println();

        LeftistHeap merge = h1.merge(h2);
        merge.printTree();
    }
}
