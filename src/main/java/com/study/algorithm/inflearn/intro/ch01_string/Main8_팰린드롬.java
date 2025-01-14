package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

/**
 * 팰린드롬: 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 의미
 */
public class Main8_팰린드롬 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println(solution(kb.nextLine()));
		// found7, time: study; Yduts; emit, 7Dnuof
	}

	private static String solution(String str) {
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println("str = " + str);
		String sb = new StringBuilder(str).reverse().toString();
		if (str.equalsIgnoreCase(sb)) {
			return "YES";
		}
		return "NO";
	}
}