package com.study.algorithm.site.programmers.level_2;

/**
 * 다시보기
 */
public class Main78 {

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    private static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        for (int i = x; i <= y; i++) {
            // 변환할수 없는 값이면 -1;
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }

            // x에 n을 더한 값
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }

            // x에 2를 곱한 값
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }

            // x에 3을 곱한 값
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
        }

        return dp[y];
    }
}