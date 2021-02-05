package com.java.repo.demo.completable_future;

import org.junit.runner.Computer;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:当前任务正常完成以后执行，当前任务的执行的结果会作为下一任务的输入参数,有返回值
 * 场景:多个任务串联执行,下一个任务的执行依赖上一个任务的结果,每个任务都有输入和输出
 * 实例1:异步执行任务A,当任务A完成时使用A的返回结果resultA作为入参进行任务B的处理,可实现任意多个任务的串联执行
 * @author GuJun
 * @date 2021/2/5
 */
public class ThenApplyDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            System.out.println("doing TaskA, Thread: " + Thread.currentThread().getName()); // doing TaskA, Thread: ForkJoinPool.commonPool-worker-1
            return "hello";
        });
        CompletableFuture<String> futureB = futureA.thenApplyAsync(s -> {
            System.out.println("doing TaskB, Thread: " + Thread.currentThread().getName()); // doing TaskB, Thread: ForkJoinPool.commonPool-worker-1
            return s + ", world";
        });
        CompletableFuture<String> futureC = futureB.thenApplyAsync(s -> {
            System.out.println("doing TaskC, Thread: " + Thread.currentThread().getName()); // doing TaskC, Thread: ForkJoinPool.commonPool-worker-1
            return s.toUpperCase();
        });
        System.out.println(futureC.get()); // HELLO, WORLD
        // 上面的代码,我们当然可以先调用future.join()先得到任务A的返回值,然后再拿返回值做入参去执行任务B,而thenApply的存在就在于帮我简化了这一步,
        // 我们不必因为等待一个计算完成而一直阻塞着调用线程，而是告诉CompletableFuture你啥时候执行完就啥时候进行下一步. 就把多个任务串联起来了.
    }
}
