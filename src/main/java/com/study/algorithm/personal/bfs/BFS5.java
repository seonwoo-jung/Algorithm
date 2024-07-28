package com.study.algorithm.personal.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

// 토마토
// todo: 이해필요
public class BFS5 {

	static int n, m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static int[][] dis;
	static Queue<Point> Q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		m = kb.nextInt();
		n = kb.nextInt();
		dis = new int[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = kb.nextInt();
				if (arr[i][j] == 1) {
					Q.offer(new Point(i, j));
				}
			}
		}
		BFS();
		System.out.println(dis[3][5]);
	}

	static void BFS() {
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
				}
			}
		}
	}

	static class Point {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}