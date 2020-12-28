package com.java.repo.code.proxy.static_proxy;

/**
 * @author GuJun
 * @date 2020/12/27
 */
public class AdminMapper implements Mapper {
    public void jdbcOp() {
        //System.out.println("========== 获取数据库链接 =========");
        System.out.println("========== 执行核心业务代码 AdminMapper ==========");
        //System.out.println("========== 关闭链接 ==========");
    }
}
