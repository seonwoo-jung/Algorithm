package com.study.algorithm.site.backjoon.other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bj_1987 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] arr;
	private static int r, c, answer = Integer.MIN_VALUE;
	private static Set<Character> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		r = kb.nextInt();
		c = kb.nextInt();

		arr = new char[r][c];

		for (int i = 0; i < r; i++) {
			String tmp = kb.next();
			char[] x = tmp.toCharArray();
			for (int j = 0; j < x.length; j++) {
				arr[i][j] = x[j];
			}
		}

		DFS(1, 0, 0);

		System.out.println(answer);
	}

	private static void DFS(int move, int x, int y) {
		set.add(arr[x][y]);
		answer = Math.max(answer, move);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
				if (!set.contains(arr[nx][ny])) {
					DFS(move + 1, nx, ny);
					set.remove(arr[nx][ny]);
				}
			}
		}
	}
}
