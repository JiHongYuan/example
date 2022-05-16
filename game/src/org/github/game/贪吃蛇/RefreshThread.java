package org.github.game.贪吃蛇;

import java.io.IOException;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/10/26 16:09
 */
public class RefreshThread extends Thread {

    public final List<Coordinate> linkedList;
    public final int[][] arr;
    public final int size;

    public RefreshThread(List<Coordinate> linkedList, int size) {
        this.linkedList = linkedList;
        this.size = size;
        this.arr = new int[size][size];
    }

    @Override
    public void run() {
//        while (!Thread.currentThread().isInterrupted()) {
        refresh();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public void direction(Coordinate coordinate, int parentDirection) {
        if (coordinate.direction == 1 && coordinate.direction != 4  && coordinate.x != 0) {
            coordinate.x--;
        } else if (coordinate.direction == 2 && coordinate.y != size) {
            coordinate.y++;
        } else if (coordinate.direction == 3 && coordinate.x != size) {
            coordinate.x++;
        } else if (coordinate.direction == 4 && coordinate.y != 0) {
            coordinate.y--;
        }
        coordinate.direction = parentDirection;
    }

    public void refresh() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }

        int parentDirection = linkedList.get(0).direction;
        for (Coordinate coordinate : linkedList) {
            int direction = coordinate.direction;
            direction(coordinate, parentDirection);
            parentDirection = direction;
        }

        for (Coordinate coordinate : linkedList) {
            arr[coordinate.x][coordinate.y] = 1;
        }

        try {
            Runtime.getRuntime().exec("cmd.exe /c cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
        printf();
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
