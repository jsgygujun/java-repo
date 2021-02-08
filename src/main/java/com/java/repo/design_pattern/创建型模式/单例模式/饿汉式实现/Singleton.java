package com.java.repo.design_pattern.创建型模式.单例模式.饿汉式实现;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Singleton {

    private Singleton() {}

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
