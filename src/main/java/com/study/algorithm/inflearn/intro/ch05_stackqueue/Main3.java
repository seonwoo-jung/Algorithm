package com.study.algorithm.inflearn.intro.ch05_stackqueue;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

/**
 * 크레인 인형뽑기(카카오)
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int[][] board = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
			}
		}

		int m = kb.nextInt();
		int[] moves = new int[m];

		for (int i = 0; i < moves.length; i++) {
			moves[i] = kb.nextInt();
		}

		int solution = solution2(board, moves);
		System.out.println("solution = " + solution);
	}

	private static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					if (stack.isEmpty()) {
						stack.push(board[j][moves[i] - 1]);
						board[j][moves[i] - 1] = 0;
					} else {
						if (stack.peek() == board[j][moves[i] - 1]) {
							stack.pop();
							board[j][moves[i] - 1] = 0;
							answer += 2;
						} else {
							stack.push(board[j][moves[i] - 1]);
							board[j][moves[i] - 1] = 0;
						}
					}
					break;
				}
			}
		}
		return answer;
	}

	private static int solution2(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int pos : moves) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][pos - 1] != 0) {
					int tmp = board[i][pos - 1];
					board[i][pos - 1] = 0;
					if (!stack.isEmpty() && tmp == stack.peek()) {
						answer += 2;
						stack.pop();
					} else {
						stack.push(tmp);
					}
					break;
				}
			}
		}
		return answer;
	}
}