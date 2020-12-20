package com.java.repo.code.lock;

/**
 * Synchronize、wait、notify 实现线程同步
 * @author GuJun
 * @date 2020/12/20
 */
public class SynchronizeWaitNotifyDemo {

    private static class SharedResource {
        private final Object object = new Object();

        void doWait() throws InterruptedException {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "即将进入阻塞");
                object.wait();
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }
        }

        void doNotify() throws InterruptedException {
            synchronized (object) {
                Thread.sleep(2000);
                object.notify();
            }
        }
    }

    public static void main(String[] args) throws Exception {
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
