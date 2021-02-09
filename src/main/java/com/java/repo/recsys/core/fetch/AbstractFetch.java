package com.java.repo.recsys.core.fetch;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.RecItem;
import com.java.repo.recsys.core.filter.AbstractFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public abstract class AbstractFetch {

    private final List<AbstractFilter> FILTER_CONTAINER = new ArrayList<>();

    protected String corpusType;
    protected String reverseType;
    protected String rSource;

    public AbstractFetch(String corpusType, String reverseType, String rSource) {
        this.corpusType = corpusType;
        this.reverseType = reverseType;
        this.rSource = rSource;
    }

    public List<RecItem> fetch(RecContext recContext, List<String> triggers) {
        return Collections.emptyList();
    }


}
