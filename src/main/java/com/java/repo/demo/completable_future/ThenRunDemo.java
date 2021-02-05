package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能: 对不关心上一步的计算结果，执行下一个操作
 * 场景: 执行任务A,任务A执行完以后,执行任务B,任务B不接受任务A的返回值(不管A有没有返回值),也无返回值
 * @author GuJun
 * @date 2021/2/5
 */
public class ThenRunDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行任务A, Thread: " + Thread.currentThread().getName()); // 执行任务A, Thread: ForkJoinPool.commonPool-worker-1
            return "TaskA";
        });
        futureA.thenRun(() -> {
            System.out.println("执行任务B, Thread: " + Thread.currentThread().getName()); // 执行任务B, Thread: main
        });
    }
}
