package com.java.repo.code.spi.impl;

import com.java.repo.code.spi.Search;

import java.util.Collections;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/12
 */
public class DatabaseSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索"+keyword);
        return Collections.emptyList();
    }
}
