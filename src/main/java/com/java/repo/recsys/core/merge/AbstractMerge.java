package com.java.repo.recsys.core.merge;

import com.java.repo.recsys.core.bean.RecItem;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
public interface AbstractMerge {

    List<RecItem> merge(List<List<RecItem>> recItems);
}
