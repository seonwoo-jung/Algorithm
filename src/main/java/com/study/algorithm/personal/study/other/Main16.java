package com.study.algorithm.personal.study.other;

import java.util.Stack;

public class Main16 {

	public static void main(String[] args) {
		int solution = solution("baabaa");
		System.out.println("solution = " + solution);
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char x : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == x) {
				stack.pop();
			} else {
				stack.push(x);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}