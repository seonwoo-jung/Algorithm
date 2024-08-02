package com.study.algorithm.book.codingtest_learn.ch05;

import java.util.ArrayDeque;

/**
 * 올바른 괄호
 */
public class Main8 {

	public static void main(String[] args) {
		boolean answer1 = solution("()()"); // t
		boolean answer2 = solution("(())()"); // t
		boolean answer3 = solution(")()("); // f
		boolean answer4 = solution("(()("); // f

		System.out.println("answer = " + answer1);
		System.out.println("answer = " + answer2);
		System.out.println("answer = " + answer3);
		System.out.println("answer = " + answer4);
	}

	static boolean solution(String s) {
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
