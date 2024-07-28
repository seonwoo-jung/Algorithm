package com.study.algorithm.personal.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

public class BFS6 {

	static int n, answer = 0;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Point> Q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		solution(board);
		System.out.println(answer);
	}

	static void solution(int[][] board) {
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

	static void BFS(int x, int y, int[][] board) {
		Q.add(new Point(x, y));

		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 1) {
					board[nx][ny] = 0;
					Q.add(new Point(nx, ny));
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