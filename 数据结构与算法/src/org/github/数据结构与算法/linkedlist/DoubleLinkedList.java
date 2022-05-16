package org.github.数据结构与算法.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/7/13 13:39
 */
public class DoubleLinkedList {
    private Node head = new Node(0);

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int i = 1; i <= 10; i++) {
            doubleLinkedList.add(new Node(i));
        }
        System.out.println(doubleLinkedList);

        doubleLinkedList.delete(5);
        System.out.println(doubleLinkedList);
    }


    static class Node {
        int val;
        DoubleLinkedList.Node next;
        DoubleLinkedList.Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 添加一个节点到链表的最后
     */
    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void delete(int val) {
        Node temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                break;
            }
            temp = temp.next;
        }

        temp.pre.next = temp.next;
        // 如果删除最后一个节点报错
        temp.next.pre = temp.pre;
    }

    @Override
    public String toString() {
        List<Integer> dataList = new ArrayList<>();
        Node curr = head.next;
        while (curr != null) {
            dataList.add(curr.val);
            curr = curr.next;
        }
        return dataList.toString();
    }
}
