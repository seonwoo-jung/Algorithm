package com.study.algorithm.book.codingtest_learn.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Main83 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		solution(3, 4, 2, 3, 3, 1, 5);
		solution(2, 2, 1, 1, 2, 2, 2);
		solution(3, 3, 1, 2, 3, 3, 4);
	}

	private static String solution(int n, int m, int x, int y, int r, int c, int k) {
		int[][] graph = new int[n][m];

		// 출발지점
		graph[x - 1][y - 1] = 1;

		// 탈출지점
		graph[r - 1][c - 1] = 2;

		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x - 1, y - 1));
		int L = 0;

		while (!Q.isEmpty()) {
			int s = Q.size();
			for (int i = 0; i < s; i++) {
				Point cur = Q.poll();
				if (graph[cur.x][cur.y] == 2 && L == 5) {
					System.out.println("L = " + L);
				}
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
						Q.offer(new Point(nx, ny));
					}
				}
			}
			L++;
		}

		return "";
	}

	private static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
