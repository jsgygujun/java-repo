package com.java.repo.design_pattern.build_pattern;

/**
 * 静态内部类实现单例模式
 * 1. 懒加载
 * 2. 线程安全
 *
 * @author GuJun
 * @date 2021/2/7
 */
public class Singleton {
    private Singleton() {}

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
