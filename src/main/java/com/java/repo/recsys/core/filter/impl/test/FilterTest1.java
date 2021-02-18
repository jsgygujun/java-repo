package com.java.repo.recsys.core.filter.impl.test;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.RecItem;
import com.java.repo.recsys.core.filter.AbstractFilter;

import java.util.Collections;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class FilterTest1 implements AbstractFilter {
    @Override
    public List<RecItem> filter(RecContext recContext, List<RecItem> recItems) {
        System.out.println(this.getClass().getSimpleName() + "->filter");
        return Collections.emptyList();
    }
}
