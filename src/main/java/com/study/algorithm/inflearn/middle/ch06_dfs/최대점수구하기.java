package com.study.algorithm.inflearn.middle.ch06_dfs;

public class 최대점수구하기 {

    private static int N, M, answer;
    private static int[][] arr;

    public static void main(String[] args) {
        System.out.println(solution(5, 20));
    }

    private static int solution(int n, int m) {
        N = n;
        M = m;
        arr = new int[][]{{10, 5}, {25, 12}, {15, 8}, {6, 3}, {7, 4}};
        DFS(0, 0, 0);
        return answer;
    }

    private static void DFS(int L, int sum, int time) {
        if (time > M) return;
        if (L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L][0], time + arr[L][1]);
            DFS(L + 1, sum, time);
        }
    }
}
