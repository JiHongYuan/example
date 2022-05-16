package com.github.游戏.俄罗斯方块;

/**
 * @author JiHongYuan
 * @date 2021/10/26 16:42
 */
public class Main {
    int[][] arr = new int[5][5];
    public static void main(String[] args) {

    }

    private void printf() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
