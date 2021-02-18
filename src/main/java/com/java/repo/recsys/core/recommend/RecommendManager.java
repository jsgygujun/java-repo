package com.java.repo.recsys.core.recommend;

import com.google.common.base.Strings;
import com.java.repo.recsys.conf.ABTestRecommendConf;
import com.java.repo.recsys.conf.RecommendConf;
import com.java.repo.recsys.core.bucket.Bucket;
import com.java.repo.recsys.core.fetch.AbstractFetch;
import com.java.repo.recsys.core.filter.AbstractFilter;
import com.java.repo.recsys.core.merge.AbstractMerge;
import com.java.repo.recsys.core.rank.AbstractRank;
import com.java.repo.recsys.core.recommend.impl.BaseRecommend;
import com.java.repo.recsys.core.rerank.AbstractReRank;
import com.java.repo.recsys.core.trigger.Trigger;
import com.java.repo.util.ConfigUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class RecommendManager {

    private Map<Bucket, AbstractRecommend> RECOMMEND_CONTAINER = new HashMap<>();

    public void addRecommend(Bucket bkt, AbstractRecommend recommend) {
        RECOMMEND_CONTAINER.put(bkt, recommend);
    }

    public static void main(String[] args) {
        RecommendManager recommendManager = new RecommendManager();
        RecommendConf baseConf = ConfigUtil.getConfig("recommendBase.conf", "baseRecommendConf", RecommendConf.class);
        AbstractRecommend baseRecommend = recommendManager.createRecommend(baseConf);
        for (Bucket bkt : baseRecommend.getBucketList()) {
            recommendManager.addRecommend(bkt, baseRecommend);
        }
        ABTestRecommendConf testConf = ConfigUtil.getConfig("recommendTest.conf", "abTestRecommendConf", ABTestRecommendConf.class);
        for (RecommendConf conf : testConf.getRecommendConfList()) {
            AbstractRecommend recommend = recommendManager.createRecommend(conf);
            for (Bucket bkt : recommend.getBucketList()) {
                recommendManager.addRecommend(bkt, recommend);
            }
        }
    }

    private AbstractRecommend createRecommend(RecommendConf conf) {
        AbstractRecommend recommend = new BaseRecommend();
        recommend.setName(conf.getName());
        for (String bkt : conf.getBkt()) {
            recommend.addBucket(Bucket.from(bkt));
        }
        try {
            for (String trigger : conf.getTrigger()) {
                Class<?> clazz = Class.forName(trigger);
                recommend.addTrigger((Trigger)clazz.newInstance());
            }
            for (String fetcher : conf.getFetcher()) {
                Class<?> clazz = Class.forName(fetcher);
                recommend.addFetcher((AbstractFetch)clazz.newInstance());
            }
            for (String filter : conf.getFilter()) {
                Class<?> clazz = Class.forName(filter);
                recommend.addFilter((AbstractFilter)clazz.newInstance());
            }
            String merger = conf.getMerger();
            if (!Strings.isNullOrEmpty(merger)) {
                Class<?> clazz = Class.forName(merger);
                recommend.setMerger((AbstractMerge)clazz.newInstance());
            }
            String ranker = conf.getRanker();
            if (!Strings.isNullOrEmpty(ranker)) {
                Class<?> clazz = Class.forName(ranker);
                recommend.setRank((AbstractRank)clazz.newInstance());
            }
            String reRanker = conf.getReRanker();
            if (!Strings.isNullOrEmpty(reRanker)) {
                Class<?> clazz = Class.forName(reRanker);
                recommend.setReRank((AbstractReRank)clazz.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommend;
    }

}
