package com.java.repo.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition.await(), condition.signal()，必须基于ReentrantLock对象
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class LockAwaitSignalDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread bbb = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("等待中...");
                condition.await();
                System.out.println("被唤醒!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "BBB");
        bbb.start();
        Thread aaa = new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.lock();
                try {
                    condition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA");
        aaa.start();
    }
}
