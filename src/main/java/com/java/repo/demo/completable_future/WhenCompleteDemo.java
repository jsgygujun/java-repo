package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，都可以进入whenComplete方法执行,举个栗子
 *
 * @author GuJun
 * @date 2021/2/5
 */
public class WhenCompleteDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println(s);//未执行
                    }
                    if (e == null) {
                        System.out.println(s);//未执行
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                })
                .exceptionally(e -> {
                    System.out.println("ex"+e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//futureA result: 100
        // 根据控制台,我们可以看出执行流程是这样,supplyAsync->whenComplete->exceptionally,可以看出并没有进入thenApply执行,
        // 原因也显而易见,在supplyAsync中出现了异常,thenApply只有当正常返回时才会去执行.而whenComplete不管是否正常执行,还要注意一点,
        // whenComplete是没有返回值的.
    }
}
