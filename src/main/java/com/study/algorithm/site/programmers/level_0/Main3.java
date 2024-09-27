package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;

/**
 * 연속된 수의 합
 */
public class Main3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, 5)));
	}

	private static int[] solution(int num, int total) {
		int[] answer = new int[num];

		// 1부터 num까지의 합계를 계산한 것
		int nSum = num * (1 + num) / 2;

		// 수열을 이동시키기 위한 조정값
		int start = (total - nSum) / num;

		for (int i = 1; i < num + 1; i++) {
			answer[i - 1] = i + start;
		}

		return answer;
	}
}
