package com.java.repo.recsys.core.rank.impl.test;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.rank.AbstractRank;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class RankTest1 implements AbstractRank {

    @Override
    public List<RecItem> rank(RecContext recContext, List<RecItem> recItems) {
        return null;
    }
}
