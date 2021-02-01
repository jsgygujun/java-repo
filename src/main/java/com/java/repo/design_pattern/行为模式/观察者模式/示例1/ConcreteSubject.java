package com.java.repo.design_pattern.行为模式.观察者模式.示例1;

/**
 * @author GuJun
 * @date 2021/2/1
 */
public class ConcreteSubject extends AbstractSubject {
    @Override
    public void notify2() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
