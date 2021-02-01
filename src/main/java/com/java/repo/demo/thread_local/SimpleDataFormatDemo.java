package com.java.repo.demo.thread_local;

import java.text.SimpleDateFormat;

/**
 * @author GuJun
 * @date 2021/1/6
 */
public class SimpleDataFormatDemo {

    private static final ThreadLocal<SimpleDateFormat> SDF = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.println(SDF.get().format(System.currentTimeMillis()));
            }, "Thread-" + i).start();;
        }
    }
}
