package com.study.algorithm.site.programmers.level_2;

public class Main79 {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
