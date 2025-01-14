package com.study.algorithm.inflearn.middle.ch01_simulation;

/**
 * 잃어버린 강아지
 */
public class Main3_잃어버린강아지 {
	public static void main(String[] args) {
		int[][] arr1 = {
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
		};
		System.out.println(solution(arr1));

		int[][] arr2 = {
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
		};
		System.out.println(solution(arr2));
	}

	private static int solution(int[][] board) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		int d1 = 0, d2 = 0;
		int count = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				// 현수 위치
				if (board[i][j] == 2) {
					x1 = i;
					y1 = j;
				}

				// 강아지 위치
				if (board[i][j] == 3) {
					x2 = i;
					y2 = j;
				}
			}
		}

		while (count < 10000) {
			if (x1 == x2 && y1 == y2) return count;

			count++;

			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];

			if (nx1 >= 0 && nx1 < board.length && ny1 >= 0 && ny1 < board.length && board[nx1][ny1] != 1) {
				x1 = nx1;
				y1 = ny1;
			} else {
				d1 = (d1 + 1) % 4;
			}

			if (nx2 >= 0 && nx2 < board.length && ny2 >= 0 && ny2 < board.length && board[nx2][ny2] != 1) {
				x2 = nx2;
				y2 = ny2;
			} else {
				d2 = (d2 + 1) % 4;
			}
		}
		return 0;
	}
}
