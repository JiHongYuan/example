package org.github.leetcode.everyday;

import java.util.*;

/**
 * medium 回溯
 *
 * @author jihongyuan
 * @date 2022/5/7 8:54
 * @see <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">乘积小于K的子数组</a>
 */
public class 最小基因变化 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"}));
    }

    static class Solution {
        Set<String> bankSet = new HashSet<>();

        public int minMutation(String start, String end, String[] bank) {

            bankSet.addAll(Arrays.asList(bank));

            if (!bankSet.contains(end)) {
                return -1;
            }

            backtracking(start, end, 0);

            return minStep == Integer.MAX_VALUE ? -1 : minStep;
        }

        private Integer minStep = Integer.MAX_VALUE;
        private final HashSet<String> steps = new HashSet<>();

        public void backtracking(String start, String end, int step) {
            if (start.equals(end)) {
                minStep = Math.min(minStep, step);
                return;
            }

            for (String bank : bankSet) {
                int diffNum = 0;
                for (int i = 0; i < bank.length(); i++) {
                    if (bank.charAt(i) != start.charAt(i)) {
                        diffNum++;
                    }
                }

                if (diffNum == 1 && !steps.contains(bank)) {
                    steps.add(bank);
                    backtracking(bank, end, step + 1);
                    steps.remove(bank);
                }
            }
        }
    }
}