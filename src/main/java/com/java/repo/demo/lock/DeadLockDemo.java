package com.java.repo.demo.lock;

/**
 * 检查死锁
 * jstack <pid>
 */
public class DeadLockDemo {

    static void lock(String lockA, String lockB) {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t持有锁["+lockA+"], 尝试加锁[" + lockB+"]~");
            try {Thread.sleep(1000);} catch (Exception e) {e.printStackTrace();}
            synchronized (lockB) {

            }
        }
    }

    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "LockB";

        new Thread(() -> {
            lock(lockA, lockB);
        }, "T1").start();

        new Thread(() -> {
            lock(lockB, lockA);
        }, "T2").start();
    }
}
