package com.java.repo.design_pattern.创建型模式.单例模式.枚举类实现;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public enum Singleton {

    INSTANCE;

    public Singleton getInstance() {
        return INSTANCE;
    }

}
