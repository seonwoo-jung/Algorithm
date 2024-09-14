package com.study.algorithm.inflearn.intro.ch01;

import static java.lang.Character.toUpperCase;
import static java.lang.System.in;

import java.util.Scanner;

/**
 * 문자 찾기
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.println(solution(str, c));
	}

	private static int solution(String str, char t) {
		int answer = 0;

		str = str.toUpperCase();
		t = toUpperCase(t);

		// String -> char[] 변환
		for (char x : str.toCharArray()) {
			if (x == t) {
				answer++;
			}
		}

		return answer;
	}
}
