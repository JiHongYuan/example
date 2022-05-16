package org.github.数据结构与算法.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/8/24 21:52
 */
public class 稀疏数组 {

    static int[][] map = new int[11][11];

    static {
        map[1][2] = 1;
        map[2][4] = 2;
    }

    public static void main(String[] args) {
        int row = map.length;
        int col = map[0].length;

        List<Integer[]> array = new ArrayList<>();
        array.add(new Integer[]{row, col, 0});
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int val = map[i][j];
                if (val != 0) {
                    array.add(new Integer[]{i, j, val});
                    count++;
                }
            }
        }
        array.get(0)[2] = count;

        for (Integer[] integers : array) {
            System.out.println(Arrays.toString(integers));
        }
    }

}
