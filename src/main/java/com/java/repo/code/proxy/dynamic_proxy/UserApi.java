package com.java.repo.code.proxy.dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author GuJun
 * @Date 2020/12/28
 */
public class UserApi implements IUserApi {
    @Override
    public String queryUserInfo() {
        return "queryUserInfo 业务代码";
    }

    /**
     * 反射示例
     * @throws Exception
     */
    @Test
    public void test_reflect() throws Exception {
        Class<UserApi> clazz = UserApi.class;
        Method queryUserInfo = clazz.getMethod("queryUserInfo");
        Object result = queryUserInfo.invoke(clazz.newInstance());
        System.out.println(result);
    }
}
