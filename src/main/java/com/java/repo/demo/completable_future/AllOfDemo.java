package com.java.repo.demo.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * allOf:当所有的CompletableFuture都执行完后执行计算
 *
 * @author GuJun
 * @date 2021/2/5
 */
public class AllOfDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品详情";
        },executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "卖家信息";
        },executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息";
        },executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息";
        },executorService);

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureA, futureB, futureC, futureD);
        allFuture.join();

        System.out.println(futureA.join() + futureB.join() + futureC.join() + futureD.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }
}
