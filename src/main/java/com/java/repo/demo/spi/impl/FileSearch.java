package com.java.repo.demo.spi.impl;

import com.java.repo.demo.spi.Search;

import java.util.Collections;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/12
 */
public class FileSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索"+keyword);
        return Collections.emptyList();
    }
}
