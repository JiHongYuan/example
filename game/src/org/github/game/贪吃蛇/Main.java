package org.github.game.贪吃蛇;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author JiHongYuan
 * @date 2021/10/21 19:52
 */
public class Main {

    static LinkedList<Coordinate> linkedList = new LinkedList<>();
    static int size = 12;

    public static void main(String[] args) {

        Thread refreshThread = new RefreshThread(linkedList, size);

        linkedList.add(new Coordinate(size / 2 + 2, size / 2, 1));
        linkedList.add(new Coordinate(size / 2 + 3, size / 2, 1));
        linkedList.add(new Coordinate(size / 2 + 4, size / 2, 1));
        linkedList.add(new Coordinate(size / 2 + 5, size / 2, 1));

        refreshThread.run();
        Scanner in = new Scanner(System.in);
        while (true) {
            String next = in.next();

            if(next.equals("w")){
                top();
            }else if(next.equals("s")){
                bottom();
            }else if(next.equals("a")){
                left();
            }else if(next.equals("d")){
                right();
            }
            refreshThread.run();
        }

    }

    public static void top() {
        linkedList.getFirst().direction = 1;
    }

    public static void right() {
        linkedList.getFirst().direction = 2;
    }

    public static void bottom() {
        linkedList.getFirst().direction = 3;
    }

    public static void left() {
        linkedList.getFirst().direction = 4;
    }

}
