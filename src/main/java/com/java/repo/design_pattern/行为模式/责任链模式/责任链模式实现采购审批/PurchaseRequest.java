package com.java.repo.design_pattern.行为模式.责任链模式.责任链模式实现采购审批;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GuJun
 * @date 2021/2/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    private double amount; // 采购金额
    private int number; // 采购编号
    private String purpose; // 采购目的
}
