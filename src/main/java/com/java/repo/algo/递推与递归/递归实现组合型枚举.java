package com.java.repo.algo.递推与递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/31
 */
public class 递归实现组合型枚举 {

    private static class Solution {
        private void dfs(int i, int m, int N, List<Integer> path, List<List<Integer>> res) {

        }

        public List<List<Integer>> solve(int n, int m) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(0, 0, n, new ArrayList<>(), res);
            return res;
        }
    }

}
