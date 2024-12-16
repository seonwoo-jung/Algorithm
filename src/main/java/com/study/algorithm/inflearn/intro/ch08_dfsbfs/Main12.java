package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 토마토(BFS)
 */
public class Main12 {

	private static int m, n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] board, dis;
	private static Queue<Point> Q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		m = kb.nextInt(); // 열
		n = kb.nextInt(); // 행
		board = new int[n][m];
		dis = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = kb.nextInt();
				if (board[i][j] == 1) {
					Q.offer(new Point(i, j));
				}
			}
		}

		BFS();

		boolean flag = true;
		int answer = MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					flag = false;
				}
			}
		}

		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

	private static void BFS() {
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
				}
			}
		}
	}

	private static class Point {

		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
