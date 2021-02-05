package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:执行两个CompletionStage的结果,那个先执行完了,就是用哪个的返回值进行下一步操作
 * 场景:假设查询商品a,有两种方式,A和B,但是A和B的执行速度不一样,我们希望哪个先返回就用那个的返回值.
 * 同样的道理,applyToEither的兄弟方法还有acceptEither(),runAfterEither(),我想不需要我解释你也知道该怎么用了.
 *
 * @author GuJun
 * @date 2021/2/5
 */
public class ApplyToEitherDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式A获取商品a";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式B获取商品a";
        });
        CompletableFuture<String> futureC = futureA.applyToEither(futureB, product -> "结果:" + product);
        System.out.println(futureC.join()); //结果:通过方式A获取商品a
    }
}
