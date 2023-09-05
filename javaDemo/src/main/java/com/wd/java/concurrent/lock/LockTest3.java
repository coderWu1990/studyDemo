package com.wd.java.concurrent.lock;

/**
 * @author wudi
 * @desc 不会死锁
 * @time 2023-08-15 15:38
 */
public class LockTest3 {
    static Object a = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTest1());//建立一个线程
        t1.setName("lock1");
        t1.start();
    }

    static class DeadLockTest1 implements Runnable {

        @Override
        public void run() {
            synchronized (a) {

                Thread t2 = new Thread(new DeadLockTest2());//建立另一个线程
                t2.setName("lock2");
                t2.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "运行");
            }
        }
    }

    static class DeadLockTest2 implements Runnable {
        @Override
        public void run() {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "运行");
            }
        }
    }
}
