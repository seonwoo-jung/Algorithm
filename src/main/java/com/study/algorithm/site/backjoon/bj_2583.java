package com.study.algorithm.site.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2583 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int m = kb.nextInt();
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < k; i++) {
			int sx = kb.nextInt();
			int sy = kb.nextInt();
			int ex = kb.nextInt();
			int ey = kb.nextInt();
			
			for (int j = sy; j < ey; j++) {
				for (int l = sx; l < ex; l++) {
					arr[j][l] = 1;
				}
			}
		}

		Queue<Point> Q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					Q.offer(new Point(i, j));
				}
				while (!Q.isEmpty()) {
					Point cur = Q.poll();
					for (int l = 0; l < 4; l++) {
						int nx = cur.x + dx[l];
						int ny = cur.y + dy[l];
						if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 0) {
							arr[nx][ny] = 1;
							Q.offer(new Point(nx, ny));
						}
					}
				}
			}
			System.out.println();
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
