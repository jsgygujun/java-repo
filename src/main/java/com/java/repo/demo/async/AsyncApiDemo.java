package com.java.repo.demo.async;

import com.java.repo.demo.util.Info;

import java.util.concurrent.*;

/**
 * @author GuJun
 * @date 2021/2/6
 */
public class AsyncApiDemo {

    private ExecutorService asyncThreadPool = Executors.newSingleThreadExecutor();

    public void cleanUp() {
        asyncThreadPool.shutdown();
    }

    // 模拟计算价格
    private double calculatePrice(String product) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to calculate price!");
        }
        return ThreadLocalRandom.current().nextDouble(0.1, 0.9);
    }

    // 获取价格同步方法
    private double getPrice(String product) {
        return calculatePrice(product);
    }

    // 获取价格异步方法
    private Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> {
            double price = getPrice(product);
            Info.withTimestampAndThread("price: " + price);
            return price;
        }, asyncThreadPool);
    }

    public static void main(String[] args) throws Exception {
        AsyncApiDemo demo = new AsyncApiDemo();
        Future<Double> future = demo.getPriceAsync("apple");
        Info.withTimestampAndThread("already submit getPrice job!");
        Info.withTimestampAndThread("do something else!");
        Info.withTimestampAndThread(future.get());
        demo.cleanUp();
    }
}
