package org.github.thread;

/**
 * @author JiHongYuan
 * @date 2021/9/11 13:59
 */
public class Test {
    public static int num;
    public static boolean ready = false;

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
//                    System.out.println(num + num);
                    if(num + num != 4){
                        System.out.println("yes");
                    }
                }
//                System.out.println("read thead...");
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("write set over");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread = new ReadThread();
        readThread.start();

        WriteThread writeThread = new WriteThread();
        writeThread.start();

        Thread.sleep(1000);
        readThread.interrupt();
        System.out.println("main exit");
    }


}
