package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

/**
 * 중복 문자 제거
 */
public class Main6_중복문자제거 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// input: ksekkset
		// output: kset
		System.out.println(solution(kb.nextLine()));
	}

	// indexOf는 문자열에서 첫 번째 문자 위치를 찾는다.
	private static String solution(String str) {
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == i) {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
}