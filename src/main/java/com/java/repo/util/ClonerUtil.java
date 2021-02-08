package com.java.repo.util;

import com.rits.cloning.Cloner;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class ClonerUtil {
    private static final Cloner CLONER = new Cloner();

    public static <T> T deepClone(T prototype) {
        return CLONER.deepClone(prototype);
    }
}
