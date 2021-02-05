package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，可以通过handle方法对结果进行处理
 *
 * @author GuJun
 * @date 2021/2/5
 */
public class HandleDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                })
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//futureA result: 100
                    } else {
                        System.out.println(e.getMessage());//未执行
                    }
                    return "handle result:" + (s == null ? "500" : s);
                });
        System.out.println(futureA.join());//handle result:futureA result: 100
        // 通过控制台,我们可以看出,最后打印的是handle result:futureA result: 100,执行exceptionally后对异常进行了"美化",返回了默认值,
        // 那么handle得到的就是一个正常的返回,我们再试下,先调用handle再调用exceptionally的情况.
        // handle和whenComplete的区别
        // 1.都是对结果进行处理,handle有返回值,whenComplete没有返回值
        // 2.由于1的存在,使得handle多了一个特性,可在handle里实现exceptionally的功能
    }
}
