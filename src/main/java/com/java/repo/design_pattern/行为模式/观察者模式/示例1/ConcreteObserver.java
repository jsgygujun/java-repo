package com.java.repo.design_pattern.行为模式.观察者模式.示例1;

/**
 * @author GuJun
 * @date 2021/2/1
 */
public class ConcreteObserver implements Observer {
    private Object object;
    @Override
    public void update() {
        System.out.println("更新～～");
    }
}
