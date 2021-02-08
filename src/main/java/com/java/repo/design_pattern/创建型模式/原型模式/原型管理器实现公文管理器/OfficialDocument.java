package com.java.repo.design_pattern.创建型模式.原型模式.原型管理器实现公文管理器;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public interface OfficialDocument extends Cloneable {

    OfficialDocument clone();

    void display();

}
