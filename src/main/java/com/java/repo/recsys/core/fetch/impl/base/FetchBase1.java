package com.java.repo.recsys.core.fetch.impl.base;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.RecItem;
import com.java.repo.recsys.core.fetch.AbstractFetch;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class FetchBase1 extends AbstractFetch {

    public FetchBase1() {
        super("", "", "");
    }

    @Override
    public List<RecItem> fetch(RecContext recContext, List<String> triggers) {
        return super.fetch(recContext, triggers);
    }
}
