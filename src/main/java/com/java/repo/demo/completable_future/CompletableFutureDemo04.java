package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CompletableFutureDemo04 {
    // 异步执行动作示例
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            return s.toUpperCase();
        });
        System.out.println(cf.join()); // MESSAGE
    }
}
