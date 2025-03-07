package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주식 가격
 */
public class Main12_주식가격 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
	}

	private static int[] solution(int[] prices) {
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
