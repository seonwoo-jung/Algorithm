package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2178_미로탐색하기 {

    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[N][M];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int L = 1;

        while (!Q.isEmpty()) {
            int[] now = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }
                board[nx][ny] = board[now[0]][now[1]] + 1;
                Q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
            L++;
        }

        System.out.println(board[N - 1][M - 1]);
    }
}
