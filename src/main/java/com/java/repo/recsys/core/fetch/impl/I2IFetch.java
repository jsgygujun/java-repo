package com.java.repo.recsys.core.fetch.impl;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.RecItem;
import com.java.repo.recsys.core.fetch.AbstractFetch;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class I2IFetch extends AbstractFetch {

    public I2IFetch(String corpusType, String reverseType, String rSource) {
        super(corpusType, reverseType, rSource);
    }

    @Override
    public List<RecItem> fetch(RecContext recContext, List<String> triggers) {
        return super.fetch(recContext, triggers);
    }
}
