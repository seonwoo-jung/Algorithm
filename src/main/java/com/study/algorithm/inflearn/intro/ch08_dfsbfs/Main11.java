package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 미로의 최단거리 통로(BFS)
 */
public class Main11 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] board, dis;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		board = new int[8][8];
		dis = new int[8][8];

		for (int i = 1; i < dis.length; i++)
			for (int j = 1; j < dis.length; j++)
				dis[i][j] = kb.nextInt();

		BFS(1, 1);

		if (dis[7][7] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
		}
	}

	private static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y] = 1; // 출발점 체크
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
}
