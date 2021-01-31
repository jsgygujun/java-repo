package com.java.repo.algo.位运算;

/**
 * @author GuJun
 * @date 2021/1/31
 */
public class 快速幂运算 {

    /**
     * 求 m^k % p
     * @param m
     * @param k
     * @param p
     * @return
     */
    public static int qmi(int m, int k, int p) {
        int res = 1 % p;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * m % p;
            }
            m = m * m % p;
            k = k >> 1;
        }
        return res;
    }

    /**
     * 求 m*k % p
     * @param m
     * @param k
     * @param p
     * @return
     */
    public static int qmi2(int m, int k, int p) {
        int res = 1 % p;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res + m % p;
            }
            m = m + m % p;
            k = k >> 1;
        }
        return res;
    }
}
