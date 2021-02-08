package com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class VicePresident extends Approver {

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("副董事长" + this.name + "审批采购单： " + request);
        } else {
            this.successor.processRequest(request); // 转发请求
        }
    }

}
