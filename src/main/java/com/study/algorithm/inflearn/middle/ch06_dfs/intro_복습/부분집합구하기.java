package com.study.algorithm.inflearn.middle.ch06_dfs.intro_복습;

/**
 * 가장 가까운 큰수
 */
public class 부분집합구하기 {

    private static int N;
    private static int[] ch;

    public static void main(String[] args) {
        solution(3);
    }

    private static void solution(int n) {
        N = n;
        ch = new int[n + 1];
        DFS(1);
    }

    private static void DFS(int L) {
        if (L == N + 1) {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 1) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
}
