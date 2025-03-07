package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.Stack;

/**
 * 짝지어 제거하기
 */
public class Main11_짝지어제거하기 {

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
