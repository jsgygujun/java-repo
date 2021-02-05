package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CompletableFutureDemo05 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName()); // pool-1-thread-1
            System.out.println(Thread.currentThread().isDaemon()); // false
            return s.toUpperCase();
        }, threadPool);
        System.out.println(cf.join()); // MESSAGE
        threadPool.shutdown();
    }
}
