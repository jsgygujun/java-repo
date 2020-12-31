package com.java.repo.code.thread_local_random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GuJun
 * @date 2020/12/31
 */
public class ThreadLocalRandomDemo {

    private static void usage() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 100));
        }
    }


    public static void main(String[] args) {
        usage();
    }
}
