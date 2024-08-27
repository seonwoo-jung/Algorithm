package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main23 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
	}

	private static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		A: for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					answer[i]++;
				} else {
					answer[i]++;
					continue A;
				}
			}
		}
		return answer;
	}
}
