package com.java.repo.demo.interrupt_exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author GuJun
 * @date 2021/1/26
 */
public class HandleInterruptExceptionInThreadPoolDemo {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);

    @Data
    @AllArgsConstructor
    private static class CPUIntensiveJob implements Runnable {
        private final CountDownLatch latch;

        @Override
        public void run() {
            try {
                int counter = 0;
                final int MAX_COUNT = ThreadLocalRandom.current().nextInt(1000, 10000);
                // 测试中断标志，并不会清除该标志
                while (!Thread.currentThread().isInterrupted() && counter < MAX_COUNT) {
                    System.out.println(Thread.currentThread().getName() + "\tCPU密集型工作线程 run() " + ++counter);
                }
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t当前工作线程接收到了中断信号，退出while循环～\t" + "counter: " + counter);
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t执行任务结束");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Future<?>> futures = new ArrayList<>();
        int jobCount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(jobCount);
        for (int i = 0; i < jobCount; ++i) {
            futures.add(threadPool.submit(new CPUIntensiveJob(countDownLatch)));
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        for (Future<?> f : futures) {
            if (!f.isDone()) {
                f.cancel(true);
            }
        }
        System.out.println("\n\n=====================================");
        jobCount = 2000;
        for (int i = 0; i < jobCount; ++i) {
            futures.add(threadPool.submit(new CPUIntensiveJob(countDownLatch)));
        }
        countDownLatch.await(100, TimeUnit.MILLISECONDS);
        for (Future<?> f : futures) {
            if (!f.isDone()) {
                f.cancel(true);
            }
        }
        threadPool.shutdown();
    }

}
