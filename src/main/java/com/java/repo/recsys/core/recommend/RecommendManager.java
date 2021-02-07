package com.java.repo.recsys.core.recommend;

import com.java.repo.recsys.core.ab.ABTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class RecommendManager {

    private Map<ABTest, AbstractRecommend> RECOMMEND_CONTAINER = new HashMap<>();

    public void addRecommend(ABTest abTest, AbstractRecommend recommend) {
        RECOMMEND_CONTAINER.put(abTest, recommend);
    }

}
