package com.java.repo.recsys.core.trigger;

import com.java.repo.recsys.core.bean.RecRequest;

import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public interface Trigger {

    public Map<String, Double> getTriggers(RecRequest recRequest);
}
