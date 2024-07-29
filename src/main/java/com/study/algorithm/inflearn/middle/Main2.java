package com.study.algorithm.inflearn.middle;

/**
 * 청소
 */
public class Main2 {
	public static void main(String[] args) {
		int k = 10;
		int[][] board = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0}
		};
		int[] solution = solution(board, k);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[][] board, int k) {
		int[] answer = new int[2];
		int pos1 = 0, pos2 = 0, idx = 0, n = board.length - 1;
		char[] forward = {'R', 'B', 'L', 'F'};

		while (k > 0) {

			if (pos1 == n ||pos2 == n) {
				idx++;
				k--;
			}

			if (board[pos1][pos2] == 1) {
				idx++;
				k--;
			} else if (board[pos1][pos2] == 0) {
				k--;
				switch (forward[idx % n]) {
					case 'R' :
						pos2++;
						break;
					case 'B' :
						pos1++;
						break;
					case 'L':
						pos2--;
						break;
					case 'F':
						pos1--;
						break;
				}
			} else {
				pos2++;
			}
		}
		answer[0] = pos1;
		answer[1] = pos2;
		return answer;
	}
}
