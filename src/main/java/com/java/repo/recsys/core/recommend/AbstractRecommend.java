package com.java.repo.recsys.core.recommend;

import com.java.repo.recsys.core.bean.RecRequest;
import com.java.repo.recsys.core.bean.RecResponse;
import com.java.repo.recsys.core.bean.Bucket;
import com.java.repo.recsys.core.fetch.AbstractFetch;
import com.java.repo.recsys.core.filter.AbstractFilter;
import com.java.repo.recsys.core.merge.AbstractMerge;
import com.java.repo.recsys.core.rank.AbstractRank;
import com.java.repo.recsys.core.rerank.AbstractReRank;
import com.java.repo.recsys.core.trigger.Trigger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public abstract class AbstractRecommend {
    private String name;
    private List<Bucket> bucketList;
    private List<Trigger> triggerList;
    private List<AbstractFetch> fetcherList;
    private List<AbstractFilter> filterList;
    private AbstractMerge merger;
    private AbstractRank ranker;
    private AbstractReRank reRanker;

    public AbstractRecommend setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public AbstractRecommend addBucket(Bucket bucket) {
        if (bucketList == null) {
            bucketList = new ArrayList<>();
        }
        bucketList.add(bucket);
        return this;
    }

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public AbstractRecommend addTrigger(Trigger trigger) {
        if (triggerList == null) {
            triggerList = new ArrayList<>();
        }
        triggerList.add(trigger);
        return this;
    }

    public List<Trigger> getTriggerList() {
        return triggerList;
    }

    public AbstractRecommend addFetcher(AbstractFetch fetch) {
        if (fetcherList == null) {
            fetcherList = new ArrayList<>();
        }
        fetcherList.add(fetch);
        return this;
    }

    public List<AbstractFetch> getFetcherList() {
        return fetcherList;
    }

    public AbstractRecommend addFilter(AbstractFilter filter) {
        if (filterList == null) {
            filterList = new ArrayList<>();
        }
        filterList.add(filter);
        return this;
    }

    public List<AbstractFilter> getFilterList() {
        return filterList;
    }

    public AbstractRecommend setMerger(AbstractMerge merger) {
        this.merger = merger;
        return this;
    }

    public AbstractMerge getMerger() {
        return merger;
    }

    public AbstractRecommend setRank(AbstractRank ranker) {
        this.ranker = ranker;
        return this;
    }

    public AbstractRank getRanker() {
        return ranker;
    }

    public AbstractRecommend setReRank(AbstractReRank reRanker) {
        this.reRanker = reRanker;
        return this;
    }

    public AbstractReRank getReRanker() {
        return reRanker;
    }

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
