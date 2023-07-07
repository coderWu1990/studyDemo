package com.wd.java.concurrent.thread;

/**
 * @author wudi
 * @desc
 * @time 2023-07-07 13:49
 */
public class HookTest {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("线程1醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1 i:" + i);
            }
        });
        t1.setName("线程1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2 i:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("线程join");
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2 i:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("线程2");

        t2.start();
        t1.start();

    }
}
