package com.study.algorithm.site.programmers.level_1;

import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * 2016년
 */
public class Main20 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s = "abcdef";
		String solution = solution(s);
		System.out.println(solution);
	}

	private static String solution(String s) {
		String answer = "";
		// 짝수
		if (s.length() % 2 == 0) {
			int len = s.length() / 2;
			char x = s.charAt(len - 1);
			char y = s.charAt(len);
			answer = valueOf(x) + valueOf(y);
			// 홀수
		} else {
			int len = s.length() / 2;
			char x = s.charAt(len);
			answer = valueOf(x);
		}
		return answer;
	}
}
