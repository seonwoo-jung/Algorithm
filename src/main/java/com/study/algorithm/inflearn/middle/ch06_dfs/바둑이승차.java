package com.study.algorithm.inflearn.middle.ch06_dfs;

/**
 * 가장 가까운 큰수
 */
public class 바둑이승차 {

    private static int C, N, answer;
    private static int[] arr;

    public static void main(String[] args) {
        System.out.println(solution(259, 5));
    }

    private static int solution(int c, int n) {
        C = c;
        N = n;
        arr = new int[]{81, 58, 42, 33, 61};
        DFS(0, 0);
        return answer;
    }

    private static void DFS(int L, int sum) {
        if (sum > C) return;
        if (L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
