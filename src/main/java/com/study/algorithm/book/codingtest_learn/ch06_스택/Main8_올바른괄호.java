package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.ArrayDeque;

/**
 * 올바른 괄호
 */
public class Main8_올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}

	private static boolean solution(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();

		char[] a = s.toCharArray();

		for (char c : a) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.pop() == c) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
