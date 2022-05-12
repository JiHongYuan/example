package org.github.leetcode.everyday;

/**
 * easy
 *
 * @author jihongyuan
 * @date 2022/5/12 10:46
 * @see <a href="https://leetcode.cn/problems/delete-columns-to-make-sorted/">乘积小于K的子数组</a>
 */
public class 删列造序 {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int result = 0;

            int n = strs.length, k = strs[0].length();

            for (int i = 0; i < k; i++) {
                char last = 0;
                for (int j = 0; j < n; j++) {
                    char current = strs[j].charAt(i);
                    if (current < last) {
                        result++;
                        break;
                    }

                    last = current;
                }
            }

            return result;
        }
    }
}
