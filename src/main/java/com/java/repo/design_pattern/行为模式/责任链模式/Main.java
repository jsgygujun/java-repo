package com.java.repo.design_pattern.行为模式.责任链模式;

import com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批.*;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Main {
    public static void main(String[] args) {
        Approver 张无忌 = new Director("张无忌");
        Approver 杨过 = new VicePresident("杨过");
        Approver 郭靖 = new President("郭靖");

        张无忌.setSuccessor(杨过);
        杨过.setSuccessor(郭靖);

        张无忌.processRequest(new PurchaseRequest(45000, 10001, "购买倚天剑"));

        张无忌.processRequest(new PurchaseRequest(65000, 10002, "购买屠龙刀"));

        张无忌.processRequest(new PurchaseRequest(100000, 10003, "购买98K"));
    }
}
