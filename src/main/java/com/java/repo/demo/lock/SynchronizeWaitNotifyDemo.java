package com.java.repo.demo.lock;

/**
 * Synchronized、wait、notify 实现线程同步，
 * 必须基于对象 synchronized(object)
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class SynchronizeWaitNotifyDemo {

    private static class SharedResource {
        private final Object object = new Object();
        void doWait() throws InterruptedException {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "即将进入阻塞");
                object.wait(); // 让当前线程睡眠在object对象锁上
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }
        }
        void doNotify() throws InterruptedException {
            synchronized (object) {
                Thread.sleep(2000);
                object.notify(); // 唤醒睡眠在object对象锁上的线程
            }
        }
    }

    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();
        new Thread(() -> {
            try {
                sharedResource.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        new Thread(() -> {
            try {
                sharedResource.doNotify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
