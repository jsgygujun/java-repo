package com.java.repo.code.thred_pool;

import java.util.concurrent.*;

/**
 * @author GuJun
 * @date 2020/12/24
 */
public class FutureDemo {

    static class AsyncTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "done";
        }
    }

    private static void futureTimeout() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> future = es.submit(new AsyncTask());
        try {
            //String str = future.get(5000, TimeUnit.MILLISECONDS);
            String str = future.get(0, TimeUnit.MILLISECONDS);
            System.out.println(str);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }

    public static void main(String[] args) {
        futureTimeout();
    }
}
