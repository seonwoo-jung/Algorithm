package com.study.algorithm.other.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.in;

// 미로탐색
public class DFS14 {

	static int answer = MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board = new int[8][8];
	static int[][] dis = new int[8][8];

	static void DFS(int x, int y) {
		if (x == 7 && y == 7) answer++;
		else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					DFS(nx, ny);
					board[nx][ny] = 0;
				}
			}
		}
	}

	static void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y] = 1;
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		BFS(1, 1);
		if (dis[7][7] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
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