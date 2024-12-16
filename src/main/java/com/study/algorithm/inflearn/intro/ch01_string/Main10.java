package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 문자 거리
 */
public class Main10 {
	public static void main(String[] args) {
		/**
		 * input: teachermode, e
		 * next()는 공백문자 전까지의 문자열을 가져옴
		 * nextLine()은 Enter 전까지의 문자열을 가져옴
		 */
		Scanner kb = new Scanner(in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		for (int x : solution(str, c)) {
			System.out.print(x + " ");
		}
	}

	private static int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		int p = 1000;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t) {
				p = 0;
				answer[i] = p;
			} else {
				p++;
				answer[i] = p;
			}
		}

		p = 1000;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == t) {
				p = 0;
			} else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		return answer;
	}
}