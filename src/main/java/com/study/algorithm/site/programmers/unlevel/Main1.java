package com.study.algorithm.site.programmers.unlevel;

/**
 * 파괴되지 않은 건물 (누적합)
 */
public class Main1 {

	public static void main(String[] args) {
//		System.out.println(solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
		System.out.println(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
	}

	private static int solution(int[][] board, int[][] skill) {
		int n = board.length;
		int m = board[0].length;
		int[][] diff = new int[n + 1][m + 1];

		// skill 연산을 diff 배열에 반영
		for (int[] s : skill) {
			int type = s[0];
			int r1 = s[1];
			int c1 = s[2];
			int r2 = s[3];
			int c2 = s[4];
			int degree = s[5];
			int val = (type == 1) ? -degree : degree;

			diff[r1][c1] += val;

			if (c2 + 1 < m) {
				diff[r1][c2 + 1] -= val;
			}
			if (r2 + 1 < n) {
				diff[r2 + 1][c1] -= val;
			}
			if (r2 + 1 < n && c2 + 1 < m) {
				diff[r2 + 1][c2 + 1] += val;
			}
		}

		// 행 기준 누적합
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				diff[i][j] += diff[i][j - 1];
			}
		}
		// 열 기준 누적합
		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				diff[i][j] += diff[i - 1][j];
			}
		}

		int answer = 0;
		// 최종 board 값 계산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] += diff[i][j];
				if (board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
