package com.study.algorithm.book.codingtest_learn.ch01;

import java.util.ArrayDeque;

/**
 * 10진수를 2진수로 변환하기
 */
public class Main9 {

	public static void main(String[] args) {
		String answer1 = solution(10); // t
		String answer2 = solution(27); // t
		String answer3 = solution(12345); // f

		System.out.println("answer = " + answer1);
		System.out.println("answer = " + answer2);
		System.out.println("answer = " + answer3);
	}

	static String solution(int decimal) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		while (decimal > 0) {
			stack.push(decimal % 2);
			decimal = decimal / 2;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}
