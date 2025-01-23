package com.study.algorithm.site.backjoon.step.ch22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14889 {

	private static int N;
	private static boolean[] visited;
	private static int[][] arr;
	private static StringTokenizer st;
	private static int MIN_RESULT = Integer.MAX_VALUE;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 1);

		System.out.println(MIN_RESULT);
	}

	private static void DFS(int L, int s) {
		if (L == N / 2) {
			MIN_RESULT = Math.min(MIN_RESULT, getResult());
		} else {
			for (int i = s; i <= N; i++) {
				visited[i] = true;
				DFS(L + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static int getResult() {
		int start = 0;
		int link = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visited[i] && visited[j]) {
					start += arr[i][j];
				}
				if (!visited[i] && !visited[j]) {
					link += arr[i][j];
				}
			}
		}
		return Math.abs(start - link);
	}
}