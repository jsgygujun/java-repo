package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CompletableFutureDemo01 {
    public static void main(String[] args) {
        // 一般用于启动异步计算
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone()); // true
        System.out.println(cf.getNow(null)); // message
    }
}
