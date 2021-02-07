package com.java.repo.recsys.core.recall;

import com.java.repo.recsys.core.ab.ABTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class RecallManager {
    private final Map<ABTest, List<AbstractRecall>> RECALL_CONTAINER = new HashMap<>();

    public void add(ABTest abTest, AbstractRecall recall) {
        List<AbstractRecall> recallList = RECALL_CONTAINER.getOrDefault(abTest, new ArrayList<>());
        recallList.add(recall);
        RECALL_CONTAINER.put(abTest, recallList);
    }
}
