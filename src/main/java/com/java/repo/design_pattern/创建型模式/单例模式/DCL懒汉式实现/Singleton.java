package com.java.repo.design_pattern.创建型模式.单例模式.DCL懒汉式实现;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
