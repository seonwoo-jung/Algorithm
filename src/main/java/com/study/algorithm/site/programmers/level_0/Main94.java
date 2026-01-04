package com.study.algorithm.site.programmers.level_0;

public class Main94 {
	public static void main(String[] args) {
		System.out.println(solution2("string", 3));
		System.out.println(solution2("love", 10));
	}

	private static String solution(String myString, int k) {
		return myString.repeat(k);
	}

	private static String solution2(String myString, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(myString);
		}
		return sb.toString();
	}
}