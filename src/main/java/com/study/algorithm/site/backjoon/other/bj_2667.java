package com.study.algorithm.site.backjoon.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_2667 {

	private static int n;
	private static int[][] arr, ch;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static List<Integer> answer;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		answer = new ArrayList<>();

		arr = new int[n][n];
		ch = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input = kb.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		solution();

		System.out.println(answer.size());
		Collections.sort(answer);
		for (Integer size : answer) {
			System.out.println(size);
		}
	}

	private static void solution() {
		Queue<int[]> Q = new LinkedList<>();
		int L = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (arr[i][j] == 1 && ch[i][j] == 0) {
					Q.offer(new int[]{i, j});
					ch[i][j] = L;
					int count = 1;

					while (!Q.isEmpty()) {
						int[] cur = Q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = cur[0] + dx[k];
							int ny = cur[1] + dy[k];

							if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
								continue;
							}

							if (arr[nx][ny] == 1 && ch[nx][ny] == 0) {
								Q.offer(new int[]{nx, ny});
								ch[nx][ny] = L;
								count++;
							}
						}
					}

					answer.add(count);
					L++;
				}
			}
		}
	}
}