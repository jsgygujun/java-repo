package com.java.repo.design_pattern.创建型模式.原型模式.原型模式实现周报_浅拷贝;

import lombok.Data;

/**
 * 利用Java对象的cloneable接口
 *
 * @author GuJun
 * @date 2021/2/8
 */
@Data
public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;

    @Override
    public WeeklyLog clone() {
        try {
            Object obj = super.clone();
            return (WeeklyLog)obj; // 浅拷贝
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

}
