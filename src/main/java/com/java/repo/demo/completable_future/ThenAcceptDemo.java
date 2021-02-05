package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 功能： 当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数,无返回值.
 * 场景： 执行任务A,同时异步执行任务B,待任务B正常返回之后,用B的返回值执行任务C,任务C无返回值
 * @author GuJun
 * @date 2021/2/5
 */
public class ThenAcceptDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {TimeUnit.SECONDS.sleep(1);} catch (Exception e) {e.printStackTrace();}
            System.out.println("执行任务A");
            return "TaskA";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行任务B");
            return "TaskB";
        });
        CompletableFuture<String> futureC = futureB.thenApplyAsync(b -> {
            System.out.println("任务B的结果： " + b);
            System.out.println("执行任务C");
            return "TaskC";
        });
        futureA.join();
        futureC.join();
    }
}
