package org.github.leetcode.everyday;

/**
 * medium 双指针
 * 在答案的帮助下写出来了
 *
 * @author jihongyuan
 * @date 2022/5/13 9:15
 * @see <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">乘积小于K的子数组</a>
 */
public class 一次编辑 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int n1 = first.length(), n2 = second.length();

            if (n1 - n2 == 1) {
                int p1 = 0, p2 = 0;

                while (p1 < n1 && p2 < n2) {
                    if (first.charAt(p1) == second.charAt(p2)) {
                        p2++;
                    }
                    p1++;
                    if (p1 - p2 > 1) return false;
                }
                return true;
            } else if (n2 - n1 == 1) {
                int p1 = 0, p2 = 0;

                while (p1 < n1 && p2 < n2) {

                    if (first.charAt(p1) == second.charAt(p2)) {
                        p1++;
                    }
                    p2++;

                    if (p2 - p1 > 1) return false;
                }
                return true;

            } else if (n1 == n2) {
                int diff = 0;
                for (int i = 0; i < n1; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) return false;
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
