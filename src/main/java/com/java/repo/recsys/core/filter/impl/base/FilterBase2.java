package com.java.repo.recsys.core.filter.impl.base;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.filter.AbstractFilter;

import java.util.Collections;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class FilterBase2 implements AbstractFilter {
    @Override
    public List<RecItem> filter(RecContext recContext, List<RecItem> recItems) {
        System.out.println(this.getClass().getSimpleName() + "->filter");
        return Collections.emptyList();
    }
}
