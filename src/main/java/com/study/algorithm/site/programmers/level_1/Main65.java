package com.study.algorithm.site.programmers.level_1;

import java.util.Stack;

/**
 * 프로그래머스 - 크레인 인형뽑기 게임
 */
public class Main65 {

	public static void main(String[] args) {
		int[][] board = new int[][]{
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 3},
			{0, 2, 5, 0, 1},
			{4, 2, 4, 4, 2},
			{3, 5, 1, 3, 1}
		};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int n = board.length;
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < n; j++) {
				if (board[j][moves[i] - 1] != 0) {
					if (stack.isEmpty()) {
						stack.push(board[j][moves[i] - 1]);
					} else {
						int x = stack.peek();
						if (x == board[j][moves[i] - 1]) {
							stack.pop();
							answer += 2;
						} else {
							stack.push(board[j][moves[i] - 1]);
						}
					}
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
