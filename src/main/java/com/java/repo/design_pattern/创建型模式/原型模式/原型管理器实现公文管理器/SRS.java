package com.java.repo.design_pattern.创建型模式.原型模式.原型管理器实现公文管理器;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class SRS implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        try {
            OfficialDocument srs = (OfficialDocument)super.clone();
            return srs;
        } catch (CloneNotSupportedException ex) {
            System.out.println("不支持复制！");
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("《软件需求说明书》");
    }
}
