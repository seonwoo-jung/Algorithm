package com.study.algorithm.site.programmers.level_0;

public class Main42 {

	public static void main(String[] args) {
		int[][] param = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
		System.out.println(solution(param));
	}

	static int solution(int[][] board) {

		int count = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					checkExplosion(i, j, board);
				}
			}
		}

		for (int[] arr : board) {
			for (int value : arr) {
				if (value == 0) count++;
			}
		}
		return count;
	}

	private static void checkExplosion(int x, int y, int[][] board) {
		int[] aroundX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] aroundY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

		int explosionX;
		int explosionY;

		for (int k = 0; k < 9; k++) {

			explosionX = x + aroundX[k];
			explosionY = y + aroundY[k];

			if (explosionX < board.length && explosionY < board.length)
				if (explosionX >= 0 && explosionY >= 0)
					board[explosionX][explosionY] = board[explosionX][explosionY] != 1 ? 2 : 1;
		}
	}
}