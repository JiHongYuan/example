package org.github.leetcode.everyday;

/**
 * 滑动窗口
 *
 * @author jihongyuan
 * @date 2022/5/5 9:43
 * @see <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">乘积小于K的子数组</a>
 */
public class 乘积小于K的子数组 {

    /**
     * example:
     * nums = {10, 5, 2, 6}
     * k = 100
     */
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK2(nums, k));
    }

    static class Solution {

        /**
         * 第一次尝试：超时
         */
        public int numSubarrayProductLessThanK1(int[] nums, int k) {
            int l = 0, r = 0;

            int result = 0;

            while (l < nums.length) {
                int sum = 1;
                for (int i = l; i <= r; i++) {
                    sum *= nums[i];
                }

                if (sum < k) {
                    r++;
                    result++;
                } else {
                    l++;
                    r = l;
                }
                if (r == nums.length) {
                    l++;
                    r = l;
                }
            }

            return result;
        }

        /**
         * 抄答案
         */
        public int numSubarrayProductLessThanK2(int[] nums, int k) {
            int current = 1;
            int result = 0;
            for (int l = 0, r = 0; r < nums.length; r++) {
                current *= nums[r];

                while (l <= r && current >= k) {
                    current /= nums[l++];
                }

                result += r - l + 1;
            }

            return result;
        }
    }

}
