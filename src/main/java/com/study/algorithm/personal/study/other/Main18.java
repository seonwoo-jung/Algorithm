package com.study.algorithm.personal.study.other;

import java.util.Stack;

public class Main18 {

	public static void main(String[] args) {
		int solution = solution("1 2 Z 3");
		System.out.println(solution);
	}

	private static int solution(String s) {
		Stack<Integer> stack = new Stack<>();
		String[] split = s.split(" ");

		for (String x : split) {
			if (x.equals("Z")) {
				stack.pop();
			} else {
				stack.push(Integer.parseInt(x));
			}
		}

		int sum = 0;

		while (!stack.isEmpty()) {
			int x = stack.pop();
			sum += x;
		}

		return sum;
	}
}