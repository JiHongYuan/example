package org.github.数据结构与算法.linkedlist;


import java.util.ArrayList;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/7/12 23:43
 */
public class LinkedList1 {
    private Node head = new Node(0);


    public static void main(String[] args) {
        LinkedList1 linkedList = new LinkedList1();

        linkedList.insert(new Node(1));
        linkedList.insert(new Node(2));
        linkedList.insert(new Node(5));

        linkedList.delete(1);
        linkedList.delete(2);
        linkedList.delete(5);
        System.out.println(linkedList);
//        LinkedList1 linkedList2 = new LinkedList1();
//
//        linkedList2.insert(new Node(1));
//        linkedList2.insert(new Node(3));
//        linkedList2.insert(new Node(4));
//
//        Node node = linkedList.mergeTwoLists(linkedList.head, linkedList2.head);
//
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }

//        Node cur = linkedList.head.next;
//        Node reverseHead = new Node(0);
//        while (cur != null) {
//            // 保存当前节点的下一个节点
//            Node next = cur.next;
//            // 将当前节点的下一个指向反转表头的最前端
//            cur.next = reverseHead.next;
//            reverseHead.next = cur;
//            // 推进
//            cur = next;
//        }
//        System.out.println(reverseHead);
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        Node prehead = new Node(-1);

        Node prev = prehead;
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
        return prehead.next;
    }

    public void insert(Node l1, int val) {

    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(Node node) {
        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = node;
    }

    public void delete(int val) {
        Node temp = head.next;
        while (true) {

            if (temp.next == null) {
                break;
            }
            if (temp.next.val == val) {
                break;
            }
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    @Override
    public String toString() {
        List<Integer> dataList = new ArrayList<>();
        LinkedList1.Node curr = head.next;
        while (curr != null) {
            dataList.add(curr.val);
            curr = curr.next;
        }
        return dataList.toString();
    }
}
