package com.study.algorithm.site.programmers.level_2;

/**
 * 프로그래머스 땅따먹기 푸는 중
 */
public class Main72 {

    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    private static int solution(int[][] land) {
        answer = Integer.MIN_VALUE;
        visited = new boolean[4];

        DFS(0, 0, land);

        return answer;
    }

    private static void DFS(int L, int sum, int[][] land) {
        if (L == land.length) {
            answer = Math.max(answer, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(L + 1, sum + land[L][i], land);
                    visited[i] = false;
                }
            }
        }
    }
}