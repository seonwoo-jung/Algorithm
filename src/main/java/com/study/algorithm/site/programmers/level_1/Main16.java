package com.study.algorithm.site.programmers.level_1;

/**
 * 콜라츠 추측
 */
public class Main16 {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

	private static int solution(long num) {
		int answer = 0;

		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = num * 3 + 1;
			}
			answer++;

			if (answer >= 500) return -1;
		}
		return answer;
	}
}
