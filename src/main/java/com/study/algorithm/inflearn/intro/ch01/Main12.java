package com.study.algorithm.inflearn.intro.ch01;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 암호
 */
public class Main12 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int num = kb.nextInt();
		String str = kb.next();
		System.out.println(solution2(num, str));
	}

	private static String solution(int i, String s) {
		String answer = "";
		s = s.replaceAll("#", "1").replaceAll("\\*", "0");
		int len = s.length() / i;
		while (s.length() >= len) {
			String subStr = s.substring(0, len);
			answer += (char) Integer.parseInt(subStr, 2);
			s = s.substring(len);
		}
		return answer;
	}

	// replace와 replaceAll의 차이
	private static String solution2(int n, String s) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(tmp, 2);
			answer += (char) num;
			s = s.substring(7);
		}
		return answer;
	}
}