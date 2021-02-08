package com.java.repo.design_pattern.创建型模式.简单工厂模式.简单工厂模式实现图表库;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Main {

    public static void main(String[] args) {
        Chart chart = ChartFactory.newChart("histogram");
        chart.display();
    }

}
