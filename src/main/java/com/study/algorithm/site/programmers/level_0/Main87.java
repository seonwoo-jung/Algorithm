package com.study.algorithm.site.programmers.level_0;

/**
 * 분수의 덧셈
 */
public class Main87 {
	public static void main(String[] args) {
		solution(1, 2, 3, 4);
	}

	// 분자, 분모 / 분자, 분모
	private static int[] solution(int numer1, int denom1, int numer2, int denom2) {

		int numer = numer1 * denom2 + numer2 * denom1;
		int denom = denom1 * denom2;

		int max = 1;

		// 최대공약수를 구한 뒤 변수 max에 담는다
		for (int i = 1; i <= numer && i <= denom; i++) {
			if (denom % i == 0 && numer % i == 0) {
				max = i;
			}
		}

		numer = numer / max;
		denom = denom / max;

		int[] answer = {numer, denom};

		return answer;
	}
}