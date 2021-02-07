package com.java.repo.recsys.core.recall;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.filter.AbstractFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public abstract class AbstractRecall {
    private final List<AbstractFilter> FILTER_CONTAINER = new ArrayList<>();

    protected abstract Map<String, Double> getTriggers(RecContext recContext) throws RuntimeException;

    public void addFilter(AbstractFilter filter) {
        FILTER_CONTAINER.add(filter);
    }


}
