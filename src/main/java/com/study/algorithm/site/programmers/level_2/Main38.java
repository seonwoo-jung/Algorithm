package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main38 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}

	private static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;

		for (int i = 3; i < sum; i++) {
			int j = sum / i;

			if (sum % i == 0 && j >= 3) {
				int col = Math.max(i, j);
				int row = Math.min(i, j);
				int center = (col - 2) * (row - 2);

				if (center == yellow) {
					answer[0] = col;
					answer[1] = row;
					return answer;
				}
			}
		}
		return answer;
	}
}