package com.java.repo.recsys.core.rerank;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public interface AbstractReRank {

    List<RecItem> reRank(RecContext recContext, List<RecItem> recItems);

}
