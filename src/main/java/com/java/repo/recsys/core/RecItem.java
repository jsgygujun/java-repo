package com.java.repo.recsys.core;

import lombok.Data;

import java.util.Objects;

/**
 * @author GuJun
 * @date 2021/2/7
 */
@Data
public class RecItem {
    private String id;
    private double weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecItem recItem = (RecItem) o;
        return Objects.equals(id, recItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
