package com.study.algorithm.book.codingtest_learn.ch13;

import java.util.Arrays;
import java.util.Collections;

public class Main53 {

	public static void main(String[] args) {
		long solution = solution(118372);
		System.out.println(solution);
	}

	private static long solution(long n) {
		String[] digits = String.valueOf(n).split("");

		Arrays.sort(digits, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (String digit : digits) {
			sb.append(digit);
		}

		return Long.parseLong(sb.toString());
	}
}
