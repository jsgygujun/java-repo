package com.java.repo.recsys.core.recommend.impl;

import com.java.repo.recsys.core.RecRequest;
import com.java.repo.recsys.core.RecResponse;
import com.java.repo.recsys.core.recommend.AbstractRecommend;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class BaseRecommend extends AbstractRecommend {

    @Override
    public RecResponse recommend(RecRequest recRequest) {
        return new RecResponse();
    }
}
