package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

/**
 * 문자 찾기
 */
public class Main1_문자찾기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.println(solution(str, c));
	}

	private static int solution(String str, char t) {
		int answer = 0;

		str = str.toUpperCase();
		t = Character.toUpperCase(t);

		// String -> char[] 변환
		for (char x : str.toCharArray()) {
			if (x == t) {
				answer++;
			}
		}

		return answer;
	}
}
