package org.github.leetcode.everyday;

/**
 * 双指针
 * 最难的是阅读理解，题目根本看不懂
 *
 * @author jihongyuan
 * @date 2022/5/9 9:45
 * @see <a href="https://leetcode.cn/problems/di-string-match/">增减字符串匹配</a>
 */
public class 增减字符串匹配 {

    static class Solution {
        public int[] diStringMatch(String s) {
            int n = s.length();
            int l = 0, r = s.length();

            int[] rst = new int[n + 1];
            for (int i = 0; i < n; i++) {
                rst[i] = s.charAt(i) == 'I' ? l++ : r--;
            }

            // 注意 n + 1, 此处 “l || r” 都看可以
            rst[n] = l;
            return rst;
        }
    }
}
