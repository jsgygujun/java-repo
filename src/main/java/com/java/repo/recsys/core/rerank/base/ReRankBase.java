package com.java.repo.recsys.core.rerank.base;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.rerank.AbstractReRank;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class ReRankBase implements AbstractReRank {

    @Override
    public List<RecItem> reRank(RecContext recContext, List<RecItem> recItems) {
        return null;
    }
}
