package com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("董事长" + this.name + "审批采购单： " + request);
    }
}
