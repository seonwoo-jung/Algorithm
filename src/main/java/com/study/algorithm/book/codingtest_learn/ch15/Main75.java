package com.study.algorithm.book.codingtest_learn.ch15;

/**
 * 가장 큰 정사각형 찾기
 */
public class Main75 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
		System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
	}

	private static int solution(int[][] board) {
		int row = board.length;
		int col = board[0].length;

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (board[i][j] == 1) {
					// 현재 위치에서 위, 왼쪽, 왼쪽 대각선 값들을 가져온다.
					int up = board[i - 1][j];
					int left = board[i][j - 1];
					int upLeft = board[i - 1][j - 1];
					// 위, 왼쪽, 왼쪽 대각선 값들이 0일수도 1일수도 있으니 Math.min을 활용한다
					board[i][j] += Math.min(up, Math.min(upLeft, left));
				}
			}
		}

		int answer = 0;

		// 보드에서 가장 큰 값을 찾기
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				answer = Math.max(answer, board[i][j]);
			}
		}

		// 정사각형 넓이 반환
		return answer * answer;
	}
}
