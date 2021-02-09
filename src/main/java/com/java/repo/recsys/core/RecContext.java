package com.java.repo.recsys.core;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GuJun
 * @date 2021/2/7
 */
@Data
public class RecContext {
    private Set<String> watchedItems = new HashSet<>();
}
