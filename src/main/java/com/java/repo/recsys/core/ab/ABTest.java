package com.java.repo.recsys.core.ab;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public enum ABTest {
    MAIN("main"),
    MAIN_BK("main_bk"),
    TEST_01("test_01"),
    TEST_02("test_02"),
    TEST_03("test_03"),
    TEST_04("test_04"),
    TEST_05("test_05"),
    TEST_06("test_06"),
    TEST_07("test_07"),
    TEST_08("test_08"),
    TEST_09("test_09"),
    TEST_10("test_10"),
    TEST_11("test_11"),
    TEST_12("test_12"),
    TEST_13("test_13"),
    TEST_14("test_14"),
    TEST_15("test_15"),
    TEST_16("test_16"),
    TEST_17("test_17"),
    TEST_18("test_18");

    ABTest(String name) {
        this.name = name;
    }

    private final String name;

    public static ABTest from(String name) {
        for (ABTest abTest : ABTest.values()) {
            if (abTest.name.equals(name)) return abTest;
        }
        return MAIN;
    }
}
