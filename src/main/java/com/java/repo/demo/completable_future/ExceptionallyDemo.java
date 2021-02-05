package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:当运行出现异常时,调用该方法可进行一些补偿操作,如设置默认值.
 * 场景:异步执行任务A获取结果,如果任务A执行过程中抛出异常,则使用默认值100返回.
 *
 * 下面代码展示了正常流程和出现异常的情况,可以理解成catch,根据返回值可以体会下.
 *
 * @author GuJun
 * @date 2021/2/5
 */
public class ExceptionallyDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "futureA result:" + s)
                .exceptionally(e -> {
                    System.out.println(e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> "执行结果:" + 50)
                .thenApply(s -> "futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");
        System.out.println(futureA.join());//futureA result: 100
        System.out.println(futureB.join());//futureB result:执行结果:50
    }
}
