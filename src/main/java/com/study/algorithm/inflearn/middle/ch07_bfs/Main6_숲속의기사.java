package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main6_숲속의기사 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 0}, {0, 2, 1, 1, 3, 0, 4, 0}, {0, 0, 0, 4, 1, 1, 1, 0}}));
		System.out.println(solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4}, {0, 1, 1, 0, 0, 0, 1, 0}, {0, 1, 4, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 1, 0}, {4, 0, 0, 0, 1, 0, 0, 0}, {4, 1, 0, 0, 1, 0, 0, 0}, {4, 0, 0, 0, 0, 0, 1, 2}}));
		System.out.println(solution(new int[][]{{4, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {0, 0, 2, 3, 4}, {0, 1, 0, 1, 0}}));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		Queue<Point> Q = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 2) {
					Q.offer(new Point(i, j, false));
				}
			}
		}
		int L = 0;

		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Point cur = Q.poll();
				if (board[cur.x][cur.y] == 3 && cur.berry) {
					return L;
				}
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 1) {
						boolean isBerry = board[nx][ny] == 4;
						Q.offer(new Point(nx, ny, isBerry));
					}
				}
			}
			L++;
		}

		return answer;
	}

	private static class Point {
		public int x, y;
		public boolean berry;

		public Point(int x, int y, boolean berry) {
			this.x = x;
			this.y = y;
			this.berry = berry;
		}
	}
}
