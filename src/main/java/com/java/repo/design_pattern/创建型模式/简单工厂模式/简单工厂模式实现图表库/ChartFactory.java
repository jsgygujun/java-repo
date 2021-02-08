package com.java.repo.design_pattern.创建型模式.简单工厂模式.简单工厂模式实现图表库;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class ChartFactory {

    public static Chart newChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
        }
        return chart;
    }

}
