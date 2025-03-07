package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.Stack;

public class Main13_크레인인형뽑기게임 {

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

	private static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		int N = board.length;
		for (int i = 0; i < moves.length; i++) {
			int y = moves[i] - 1;
			for (int j = 0; j < N; j++) {
				if (board[j][y] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[j][y]) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[j][y]);
					}
					board[j][y] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
