package com.study.algorithm.inflearn.middle.ch06_dfs.intro_복습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드BFS {

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] arr;

    private static Queue<int[]> Q;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Q = new LinkedList<>();
        arr = new int[n][n];
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    Q.offer(new int[]{i, j});
                    BFS(n, arr);
                    answer++;
                }
            }
        }
        System.out.println("answer = " + answer);
    }

    private static void BFS(int n, int[][] arr) {
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
