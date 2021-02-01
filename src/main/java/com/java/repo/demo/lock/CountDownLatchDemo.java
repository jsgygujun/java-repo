package com.java.repo.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch
 * countDown(), await()
 *
 * @author GuJun
 * @date 2021/1/21
 */
public class CountDownLatchDemo {

    private static final CountDownLatch CDL = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("线程：" + Thread.currentThread().getName() + " 执行countDown~~~");
                    CDL.countDown(); // 当countDownLatch内部计数值不为0，则线程被阻塞在这里。
                    System.out.println("线程：" + Thread.currentThread().getName() + " 被唤醒～～～");
                }
            }, "Thread--"+i).start();
        }
        System.out.println("await~~~");
        CDL.await();
        System.out.println("exit~~~");
    }
}
