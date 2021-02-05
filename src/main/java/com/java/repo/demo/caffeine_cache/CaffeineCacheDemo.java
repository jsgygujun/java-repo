package com.java.repo.demo.caffeine_cache;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GuJun
 * @date 2021/2/5
 */
public class CaffeineCacheDemo {
    private final LoadingCache<String, Optional<Object>> cache = Caffeine
            .newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(Duration.ofHours(1))
            .build(this::loadKey); // 可以缓存Optional.empty();

    private Optional<Object> loadKey(String key) {
        System.out.println("loadKey: " + key);
        if (ThreadLocalRandom.current().nextBoolean()) {
            return Optional.of(key + "-" + ThreadLocalRandom.current().nextInt(100));
        }
        return Optional.empty();
    }

    private final LoadingCache<String, Object> cache2 = Caffeine
            .newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(Duration.ofHours(1))
            .build(this::loadKey2); // 不缓存null

    private Object loadKey2(String key) {
        System.out.println("loadKey2: " + key);
        if (ThreadLocalRandom.current().nextBoolean()) {
            return key + "-" + ThreadLocalRandom.current().nextInt(100);
        }
        return null;
    }

    private final LoadingCache<String, Optional<Object>> cache3 = Caffeine
            .newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(Duration.ofHours(1))
            .build(this::loadKey3WithException);

    private Optional<Object> loadKey3WithException(String key) throws Exception {
        System.out.println("loadKey3" + key);
        if (ThreadLocalRandom.current().nextBoolean()) {
            return Optional.of(key + "-" + ThreadLocalRandom.current().nextInt(100));
        }
        throw new Exception("Failed to loadKey3");
    }

    public static void main(String[] args) {
//        CaffeineCacheDemo caffeineCacheDemo = new CaffeineCacheDemo();
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(caffeineCacheDemo.cache.get(i+""));
//        }
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(caffeineCacheDemo.cache.get(i+""));
//        }

//        CaffeineCacheDemo caffeineCacheDemo = new CaffeineCacheDemo();
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(caffeineCacheDemo.cache2.get(i+""));
//        }
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(caffeineCacheDemo.cache2.get(i+""));
//        }

        CaffeineCacheDemo caffeineCacheDemo = new CaffeineCacheDemo();
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println(caffeineCacheDemo.cache3.get(i + "")); // 抛出异常
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println(caffeineCacheDemo.cache3.get(i + "")); // 抛出异常
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
