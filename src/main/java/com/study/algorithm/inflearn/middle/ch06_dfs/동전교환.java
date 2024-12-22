package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.Arrays;
import java.util.Collections;

public class 동전교환 {

    private static int N, M, answer;
    private static Integer[] arr;

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    private static int solution(int n) {
        N = n;
        M = 15;
        arr = new Integer[]{1, 2, 5};
        Arrays.sort(arr, Collections.reverseOrder());
        answer = Integer.MAX_VALUE;
        DFS(0, 0);
        return answer;
    }

    private static void DFS(int L, int sum) {
        if (sum > M) return;
        if (L >= answer) return;
        if (sum == M) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < N; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }
}
