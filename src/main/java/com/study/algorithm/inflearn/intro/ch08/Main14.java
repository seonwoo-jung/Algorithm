package com.study.algorithm.inflearn.intro.ch08;

import static java.lang.System.in;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬나라 아일랜드(BFS)
 */
public class Main14 {

	private static int answer = 0, n;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}

		solution(arr);

		System.out.println(answer);
	}

	private static void BFS(int x, int y, int[][] board) {
		queue.add(new Point(x, y));
		while (!queue.isEmpty()) {
			Point pos = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
					board[nx][ny] = 0;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}

	private static void solution(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answer++;
					board[i][j] = 0;
					BFS(i, j, board);
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
