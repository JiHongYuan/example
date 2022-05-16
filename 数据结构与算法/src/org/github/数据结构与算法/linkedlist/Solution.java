package org.github.数据结构与算法.linkedlist;


import java.util.Stack;

/**
 * @author JiHongYuan
 * @date 2021/7/13 22:22
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        ListNode cur = listNode;
        for (int i : new int[]{2, 3, 4, 5}) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        solution.printf(listNode);

//        solution.removeNthFromEnd(listNode, 2);
//        solution.printf(listNode);
//        solution.printf(solution.reverseList(listNode));

        System.out.println(solution.isPalindrome(listNode));
        System.out.println(solution.deleteNode(listNode, 1));
        solution.printf(listNode);
    }

    public void printf(ListNode listNode) {
        ListNode cur = listNode;
        while (cur != null) {
            System.out.printf("%d\t", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 合并两个链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dataNode = new ListNode();
        ListNode prev = dataNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dataNode.next;
    }

    /**
     * 删除链表的倒数第 N 个结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        cur = dummy;
        for (int i = 0; i < size - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 反转一个链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;

            cur = temp;
        }
        return pre;
    }

    /**
     * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;

        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        cur = head;
        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            if (stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;

        ListNode cur = head;
        while (cur.next.val != val) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return null;
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
