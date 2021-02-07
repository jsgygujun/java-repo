package com.java.repo.recsys.core.recommend;

import com.java.repo.recsys.core.RecRequest;
import com.java.repo.recsys.core.RecResponse;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public abstract class AbstractRecommend {

    public abstract RecResponse recommend(RecRequest recRequest);

    protected RecResponse recommend0(RecRequest recRequest) {
        try {
            return recommend(recRequest);
        } catch (Exception e) {
            // 进行兜底
            return new RecResponse();
        }
    }

}
