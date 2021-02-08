package com.java.repo.design_pattern.创建型模式.单例模式.静态内部类实现;

/**
 * 静态内部类实现单利
 *
 * @author GuJun
 * @date 2021/2/8
 */
public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
