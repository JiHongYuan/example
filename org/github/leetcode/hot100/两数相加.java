package org.github.leetcode.hot100;

/**
 * medium 链表
 * 这题还挺有意思
 *
 * @author jihongyuan
 * @date 2022/5/10 9:40
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/submissions/">两数相加</a>
 */
public class 两数相加 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;

            int carray = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 == null ? 0 : l1.val;
                int n2 = l2 == null ? 0 : l2.val;

                int sum = n1 + n2 + carray;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }

                carray = sum / 10;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if (carray > 0) {
                tail.next = new ListNode(carray);
            }
            return head;
        }
    }
}
