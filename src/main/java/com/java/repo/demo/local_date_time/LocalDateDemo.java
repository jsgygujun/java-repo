package com.java.repo.demo.local_date_time;

import java.time.LocalDateTime;

/**
 * @author GuJun
 * @date 2021/1/6
 */
public class LocalDateDemo {

    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2021-01-06T20:10:03.736
    }

    public static void main(String[] args) {
        localDateTime();
    }
}
