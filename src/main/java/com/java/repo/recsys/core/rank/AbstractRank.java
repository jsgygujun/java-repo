package com.java.repo.recsys.core.rank;

import com.java.repo.recsys.core.RecContext;
import com.java.repo.recsys.core.RecItem;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public interface AbstractRank {

    List<RecItem> rank(RecContext recContext, List<RecItem> recItems);

}
