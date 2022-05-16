package org.github.数据结构与算法.linkedlist;

/**
 * @author JiHongYuan
 * @date 2021/7/13 22:22
 */

public class ListNode {
    public int val;
    ListNode next;


    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
