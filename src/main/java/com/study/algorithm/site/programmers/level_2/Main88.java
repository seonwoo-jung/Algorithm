package com.study.algorithm.site.programmers.level_2;

public class Main88 {

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(solution(i));
		}
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(10));
	}

	private static String solution(int n) {
		String[] num = {"4", "1", "2"};
		String answer = "";

		while (n > 0) {
			answer = num[n % 3] + answer;
			n = (n - 1) / 3;
		}
		return answer;
	}
}