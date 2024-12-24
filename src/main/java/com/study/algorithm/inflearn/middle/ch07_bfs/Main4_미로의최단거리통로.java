package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main4_미로의최단거리통로 {

    private static int[][] dist;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}
        };
        System.out.println(solution(arr));
        for (int[] x : dist) {
            System.out.println(Arrays.toString(x));
        }

        int[][] arr2 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        };
        System.out.println(solution(arr2));
    }

    private static int solution(int[][] board) {
        int n = board.length;
        dist = new int[n][n];
        int L = 0;
        Queue<int[]> Q = new LinkedList<>();
        board[0][0] = 1;
        Q.offer(new int[]{0, 0});

        while (!Q.isEmpty()) {
            L++;
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                if (cur[0] == 6 && cur[1] == 6) return L;
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }
        return -1;
    }
}
