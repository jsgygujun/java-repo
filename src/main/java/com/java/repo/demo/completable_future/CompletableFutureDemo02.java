package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CompletableFutureDemo02 {
    public static void main(String[] args) {
        // 运行简单异步场景
        // 1. CompletableFuture 是异步执行方式；
        // 2. 使用 ForkJoinPool 实现异步执行，这种方式使用了 daemon 线程执行 Runnable 任务。
        CompletableFuture<Void> cf = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            System.out.println(Thread.currentThread().isDaemon()); // true
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(cf.isDone()); // false
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(cf.isDone()); // true
    }
}
