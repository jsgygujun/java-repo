package com.java.repo.recsys.core.trigger.test;

import com.java.repo.recsys.core.RecRequest;
import com.java.repo.recsys.core.trigger.Trigger;

import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public class TriggerTest1 implements Trigger {

    @Override
    public Map<String, Double> getTriggers(RecRequest recRequest) {
        return null;
    }
}
