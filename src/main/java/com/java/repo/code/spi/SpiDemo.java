package com.java.repo.code.spi;

import java.util.ServiceLoader;

/**
 * Java
 * @author GuJun
 * @date 2021/1/12
 */
public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<Search> sl = ServiceLoader.load(Search.class);
        for (Search search : sl) {
            search.searchDoc("hello world");
        }
    }
}
