package com.java.repo.recsys.core.rerank.test;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.rerank.AbstractReRank;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class ReRankTest1 implements AbstractReRank {

    @Override
    public List<RecItem> reRank(RecContext recContext, List<RecItem> recItems) {
        return null;
    }
}
