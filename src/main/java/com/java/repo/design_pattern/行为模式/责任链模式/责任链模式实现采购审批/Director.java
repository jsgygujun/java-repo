package com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    // 具体请求处理方法
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("主任" + this.name + "审批采购单" + request);
        } else {
            this.successor.processRequest(request); // 转发请求
        }
    }

}
