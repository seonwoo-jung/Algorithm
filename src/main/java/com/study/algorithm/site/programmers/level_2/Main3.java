package com.study.algorithm.site.programmers.level_2;

import java.util.Stack;

public class Main3 {

	public static void main(String[] args) {
		boolean solution = solution("(()(");
		System.out.println("solution = " + solution);
	}

	private static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char x : s.toCharArray()) {
			if (x == '(') {
				stack.push(x);
			} else if (x == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
}
