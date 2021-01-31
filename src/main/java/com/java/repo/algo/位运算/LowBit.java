package com.java.repo.algo.位运算;

/**
 * @author GuJun
 * @date 2021/1/31
 */
public class LowBit {

    public static int lowBit(int n) {
        return (-n) & n;
    }

    public static void main(String[] args) {
        System.out.println(lowBit(5));
        System.out.println(lowBit(4));
    }
}
