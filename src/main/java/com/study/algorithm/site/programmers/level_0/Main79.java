package com.study.algorithm.site.programmers.level_0;

public class Main79 {
	public static void main(String[] args) {
		String solution = solution("abcdef", "f");
		System.out.println("solution = " + solution);
	}

	private static String solution(String my_string, String letter) {
		return my_string.replaceAll(letter, "");
	}
}