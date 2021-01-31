package com.java.repo.algo.递推与递归;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/31
 */
public class 递归实现指数型枚举 {

    // 从 1～n 这 n 个整数中随机选择任意多个，输出所有可能的选择方案
    private static class Solution {
        void dfs(int i, int N, List<Integer> path, List<List<Integer>> res) {
            // 边界条件
            if (i == N) {
                res.add(new ArrayList<>(path));
                return;
            }

            dfs(i+1, N, path, res);

            path.add(i+1);
            dfs(i+1, N, path, res);
            path.remove(path.size()-1);
        }

        public List<List<Integer>> solve(int n) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(0, n, new ArrayList<>(), res);
            return res;
        }
    }

    @Test
    public void test_1() {
        System.out.println(new Solution().solve(3));
    }
}
