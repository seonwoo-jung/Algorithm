package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main2_집으로이동 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(solution(new int[]{10, 15, 20}, 3, 2, 2));
    }

    private static int solution(int[] pool, int a, int b, int home) {
        Queue<int[]> Q = new LinkedList<>();
        int[][] ch = new int[2][10001];

        // 웅덩이 지점 체크
        for (int x : pool) {
            ch[0][x] = 1;
            ch[1][x] = 1;
        }

        // 출발지점 체크
        ch[0][0] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0}); // 순서쌍은 (지점, 해당 지점 올 때 점프여부(0번: 점프, 1번: 뒤로 점프))
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                if (cur[0] == home) return L;
                int nx = cur[0] + a;
                if (nx <= 10001 && ch[0][nx] == 0) {
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if (nx >= 0 && ch[1][nx] == 0 && cur[1] == 0) {
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }
}
