package com.java.repo.demo.completion_service;

import com.java.repo.demo.util.Info;
import lombok.AllArgsConstructor;

import java.util.concurrent.*;

/**
 * @author GuJun
 * @date 2021/2/9
 */
public class CompletionServiceDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(es);
        for (int i = 0; i < 10; ++i) {
            cs.submit(new AsyncTask());
        }
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println(cs.poll(1, TimeUnit.SECONDS).get(1, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("time:" + (System.currentTimeMillis()-ts));
        es.shutdown();
    }

    @AllArgsConstructor
    private static class AsyncTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            long ts = System.currentTimeMillis();
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 4000));
            Info.withTimestampAndThread("time: " + (System.currentTimeMillis()-ts));
            return ThreadLocalRandom.current().nextInt(0, 1000);
        }
    }
}
