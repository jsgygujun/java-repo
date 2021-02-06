package com.java.repo.demo.util;

import java.time.LocalDateTime;

/**
 * @author GuJun
 * @date 2021/2/6
 */
public class Info {
    public static void withTimestampAndThread(Object msg) {
        System.out.println(LocalDateTime.now() + ": " + Thread.currentThread().getName() + " -> " + msg.toString());
    }
}
