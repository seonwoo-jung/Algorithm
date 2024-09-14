package com.study.algorithm.site.programmers.level_1;

public class Main27 {

	public static void main(String[] args) {
		int solution = solution(13, 17);
		System.out.println("solution = " + solution);
	}

	private static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int cnt = 1;

			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) cnt++;
			}

			if (cnt % 2 == 0) answer += i;
			else answer -= i;
		}

		return answer;
	}
}
