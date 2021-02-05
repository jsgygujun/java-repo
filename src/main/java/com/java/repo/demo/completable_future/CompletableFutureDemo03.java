package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CompletableFutureDemo03 {
    public static void main(String[] args) {
        // 同步执行动作示例
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.out.println(Thread.currentThread().getName()); // main
            return s.toUpperCase();
        });
        System.out.println(cf.getNow(null)); // MESSAGE
    }
}
