package com.study.algorithm.book.codingtest_learn.ch06_스택;

import java.util.ArrayDeque;

/**
 * 10진수를 2진수로 변환하기
 */
public class Main9_10진수를2진수로변환하기 {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(27));
		System.out.println(solution(12345));
	}

	private static String solution(int decimal) {
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
