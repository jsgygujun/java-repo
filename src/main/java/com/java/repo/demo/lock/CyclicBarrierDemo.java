package com.java.repo.demo.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author GuJun
 * @date 2021/1/21
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙～～");
        });
        for (int i = 1; i <= 7; ++i) {
            final int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集到第「" + finalI + "」颗龙珠～～");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "Thread---"+i).start();
        }
    }
}
