package com.study.algorithm.inflearn.intro.ch01;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.System.in;

public class Main1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.println(solution(str, c));
	}

	public static int solution(String str, char t) {
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
