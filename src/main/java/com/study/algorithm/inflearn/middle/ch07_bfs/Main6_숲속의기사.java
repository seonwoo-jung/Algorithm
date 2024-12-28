package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main6_숲속의기사 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 0}, {0, 2, 1, 1, 3, 0, 4, 0}, {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4}, {0, 1, 1, 0, 0, 0, 1, 0}, {0, 1, 4, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 1, 0}, {4, 0, 0, 0, 1, 0, 0, 0}, {4, 1, 0, 0, 1, 0, 0, 0}, {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(solution(new int[][]{{4, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {0, 0, 2, 3, 4}, {0, 1, 0, 1, 0}}));
    }

    private static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    Q.offer(new int[]{i, j});
                    int[][] ch = new int[n][m];
                    ch[i][j] = 1;
                    int L = 0;
                    while (!Q.isEmpty()) {
                        L++;
                        int len = Q.size();
                        for (int r = 0; r < len; r++) {
                            int[] cur = Q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
                                    if (ch[nx][ny] == 0) {
                                        ch[nx][ny] = 1;
                                        dist[nx][ny] += L;
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        return answer;
    }
}
