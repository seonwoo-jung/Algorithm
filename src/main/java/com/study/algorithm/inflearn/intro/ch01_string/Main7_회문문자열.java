package com.study.algorithm.inflearn.intro.ch01_string;

import java.util.Scanner;

/**
 * 회문 문자열 (앞에서부터 읽던, 뒤에서부터 읽던 같은 문자열을 의미)
 */
public class Main7_회문문자열 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println(solution3(kb.nextLine()));
	}

	private static String solution(String str) {
		int lt = 0, rt = str.length() - 1;
		str = str.toLowerCase();
		while (lt < rt) {
			if (!(str.charAt(lt) == str.charAt(rt))) {
				return "NO";
			}
			lt++;
			rt--;
		}
		return "YES";
	}

	private static String solution2(String str) {
		str = str.toUpperCase();
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return "NO";
			}
		}
		return "YES";
	}

	private static String solution3(String str) {
		String tmp = new StringBuilder(str).reverse().toString();
		if (str.equalsIgnoreCase(tmp)) {
			return "YES";
		}
		return "NO";
	}
}