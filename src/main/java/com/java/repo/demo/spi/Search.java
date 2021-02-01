package com.java.repo.demo.spi;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/12
 */
public interface Search {
    List<String> searchDoc(String keyword);
}
