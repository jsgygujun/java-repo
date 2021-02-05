package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * 功能:结合两个CompletionStage的结果，进行转化后返回
 * 场景:需要根据商品id查询商品的当前价格,分两步,查询商品的原始价格和折扣,这两个查询相互独立,当都查出来的时候用原始价格乘折扣,算出当前价格. 使用方法:thenCombine(..)
 * @author GuJun
 * @date 2021/2/5
 */
public class ThenCombineDemo {
    public static void main(String[] args) {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> 100d);
        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> 0.8);
        CompletableFuture<Double> futureResult = futurePrice.thenCombine(futureDiscount, (price, discount) -> price * discount);
        System.out.println("最终价格为:" + futureResult.join()); //最终价格为:80.0
        // thenCombine(..)是结合两个任务的返回值进行转化后再返回,那如果不需要返回呢,那就需要thenAcceptBoth(..),同理,
        // 如果连两个任务的返回值也不关心呢,那就需要runAfterBoth了,如果理解了上面三个方法,thenApply,thenAccept,thenRun,
        // 这里就不需要单独再提这两个方法了,只在这里提一下.
    }
}
