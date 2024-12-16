package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 문자열 압축
 * input: KKHSSSSSSSE
 * output: K2HS7E
 */
public class Main11 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		String str = kb.next();
		System.out.println(solution(str));
	}

	private static String solution(String s) {
		String answer = "";
		s = s + " "; // 문자열에 빈 문자 하나를 추가해줘야 아래 알고리즘 사용가능
		int cnt = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				cnt++;
			} else {
				answer += s.charAt(i);
				if (cnt > 1) {
					answer += String.valueOf(cnt);
					cnt = 1;
					// 또는 Integer.toString();
				}
			}
		}
		return answer;
	}
}