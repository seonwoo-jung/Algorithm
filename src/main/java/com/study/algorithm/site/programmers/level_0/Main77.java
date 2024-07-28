package com.study.algorithm.site.programmers.level_0;

public class Main77 {
	public static void main(String[] args) {

		String hello = solution("hello", 3);
		System.out.println("hello = " + hello);
	}

	static String solution(String my_string, int n) {
		String answer = "";

		char[] a = my_string.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < n; j++) {
				answer += a[i];
			}
		}
		return answer;
	}
}