package com.study.algorithm.site.programmers.level_1;

/**
 * 정수 내림차순으로 배치하기(23.12.11)
 */
public class Main13 {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

	static long solution(long n) {
		String answer = "";
		char[] x = String.valueOf(n).toCharArray();
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] < x[j]) {
					char tmp = x[i];
					x[i] = x[j];
					x[j] = tmp;
				}
			}
		}
		for (char c : x) {
			answer += c;
		}

		return Long.parseLong(answer);
	}
}
