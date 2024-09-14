package com.study.algorithm.book.codingtest_learn.ch14;

public class Main1 {

	private static int length;
	private static int[][] board;

	public static void main(String[] args) {
		int[][] solution = solution(new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			},
			3
		);

		int[][] solution2 = solution(new int[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
			},
			3
		);

		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[i].length; j++) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, solution[i][j]);
			}
		}
	}

	private static int[][] solution(int[][] arr, int n) {
		length = arr.length;
		board = arr;
		int[][] answer = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				answer[i][j] = calculate(n, i, j);
			}
		}

		return answer;
	}

	private static int calculate(int direction, int i, int j) {
		switch (direction) {
			case 1:
				return board[(length - 1) - j][i];
			case 2:
				return board[(length - 1) - i][(length - 1) - j];
			case 3:
				return board[j][(length - 1) - i];
			case 4:
				return board[i][j];
		}
		return 0;
	}
}
