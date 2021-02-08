package com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批;

/**
 * 审批者
 * @author GuJun
 * @date 2021/2/8
 */
public abstract class Approver {
    protected Approver successor; // 后继对象
    protected String name; // 审批者姓名

    public Approver(String name) {
        this.name = name;
    }

    // 设置后继
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    // 抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);
}
