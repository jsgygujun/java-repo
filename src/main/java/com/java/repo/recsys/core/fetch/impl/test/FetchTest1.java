package com.java.repo.recsys.core.fetch.impl.test;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.fetch.AbstractFetch;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class FetchTest1 extends AbstractFetch {

    public FetchTest1() {
        super("", "", "");
    }

    @Override
    public List<RecItem> fetch(RecContext recContext, List<String> triggers) {
        return super.fetch(recContext, triggers);
    }
}
