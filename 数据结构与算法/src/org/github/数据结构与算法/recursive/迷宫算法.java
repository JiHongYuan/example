package org.github.数据结构与算法.recursive;

import javax.print.DocFlavor;

/**
 * @author JiHongYuan
 * @date 2021/7/15 10:44
 */
public class 迷宫算法 {
    public static int row = 8;
    public static int col = 7;

    public static void main(String[] args) {

        int[][] map = new int[row][col];
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        for (int i = 0; i < col; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        printMap(map);


        setWay(map, 1, 1);
        printMap(map);
    }


    /**
     * 重点在右下角
     *
     * @param map element:
     *            0:没有走
     *            1:墙 ;
     *            2:已经走过了;
     *            3.回头
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[row - 2][col - 2] == 2) {
            return true;
        }

        if (map[i][j] == 0) {
            map[i][j] = 2;

            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d  ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
