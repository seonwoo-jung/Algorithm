package com.study.algorithm.book.codingtest_learn.ch06;

import java.util.Stack;

/**
 * 주식 가격
 */
public class Main12 {

	public static void main(String[] args) {
		int[] solution = solution(new int[]{1, 2, 3, 2, 3});
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[] prices) {
		int N = prices.length;
		int[] answer = new int[N];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int j = stack.pop();
			answer[j] = N - 1 - j;
		}
		return answer;
	}
}
