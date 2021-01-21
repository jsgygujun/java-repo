package com.java.repo.code.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 多个线程抢多个资源
 *
 * @author GuJun
 * @date 2021/1/21
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; ++i) {
            new Thread(() -> {
                try {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " 抢到车位～～～");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName() + " 停车1秒离开～～～");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    semaphore.release();
                }
            }, "Thread---" + i).start();
        }
    }
}
