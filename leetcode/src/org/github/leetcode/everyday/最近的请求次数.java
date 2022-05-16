package org.github.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * easy 队列
 *
 * @author jihongyuan
 * @date 2022/5/6 9:23
 * @see <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">乘积小于K的子数组</a>
 */
public class 最近的请求次数 {
    class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);

            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }
}
