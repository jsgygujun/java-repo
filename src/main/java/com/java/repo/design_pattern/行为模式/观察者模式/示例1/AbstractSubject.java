package com.java.repo.design_pattern.行为模式.观察者模式.示例1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/1
 */
public abstract class AbstractSubject {
    // 定义一个观察者集合用于存储所有观察者对象
    protected List<Observer> observers = new LinkedList<>();
    // 注册方法，用于向观察者集合中增加一个观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }
    // 注销方法，用于在观察者集合中删除一个观察者
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    // 声明抽象通知方法
    public abstract void notify2();
}
