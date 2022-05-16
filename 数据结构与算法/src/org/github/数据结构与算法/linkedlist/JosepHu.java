package org.github.数据结构与算法.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/7/13 14:15
 */
public class JosepHu {


    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.builder(10);
        System.out.println(circleSingleLinkedList);
        circleSingleLinkedList.countNode(1,2);
    }

    static class CircleSingleLinkedList {
        private Node first = new Node(-1);

        public void builder(int vals) {
            Node currNode = null;
            for (int i = 1; i <= vals; i++) {
                Node node = new Node(i);
                if (i == 1) {
                    first = node;
                    first.next = first;
                    currNode = first;
                } else {
                    node.next = first;
                    currNode.next = node;
                    currNode = node;
                }
            }
        }

        /**
         * @param k 从第几个开始
         * @param m 隔几个删除
         */
        public void countNode(int k, int m) {
            Node helper = first;

            // 将helper移动到循环链表的尾部
            while (helper.next != first) {
                helper = helper.next;
            }

            // 移动k - 1距离
            for (int i = 0; i < k; i++) {
                helper = helper.next;
                first = first.next;
            }

            // 循环删除
            while (true) {

                // 直至链表中只有一个元素
                if (helper == first) {
                    break;
                }

                // 移动m - 1距离
                for (int i = 0; i < k; i++) {
                    helper = helper.next;
                    first = first.next;
                }

                System.out.println(first.val);
                first = first.next;
                helper.next = first;
            }

        }

        @Override
        public String toString() {
            List<Integer> dataList = new ArrayList<>();
            Node curr = first;
            while (curr != null) {
                dataList.add(curr.val);
                Node next = curr.next;
                if (next == first) break;
                curr = next;
            }
            return dataList.toString();
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
