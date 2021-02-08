package com.java.repo.design_pattern.创建型模式.简单工厂模式.简单工厂模式实现图表库;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class LineChart implements Chart {

    public LineChart() {
        System.out.println("创建折线图");
    }

    public void display() {
        System.out.println("显示折线图");
    }

}
