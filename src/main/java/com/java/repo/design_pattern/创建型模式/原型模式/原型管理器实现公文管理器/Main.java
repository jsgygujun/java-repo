package com.java.repo.design_pattern.创建型模式.原型模式.原型管理器实现公文管理器;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Main {

    public static void main(String[] args) {
        PrototypeManager pm = PrototypeManager.getInstance();
        OfficialDocument doc1, doc2, doc3, doc4;
        doc1 = pm.getOfficialDocument("far");
        doc1.display();
        doc2 = pm.getOfficialDocument("far");
        doc2.display();

        doc3 = pm.getOfficialDocument("srs");
        doc3.display();
        doc4 = pm.getOfficialDocument("srs");
        doc4.display();

        System.out.println(doc1 == doc2);
        System.out.println(doc3 == doc4);
    }

}
