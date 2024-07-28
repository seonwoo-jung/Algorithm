package com.study.algorithm.site.programmers.level_0;

import static java.util.Arrays.sort;

public class Main41 {

	public static void main(String[] args) {
		int[] param = {1, 2};
		solution(param);
	}

	static int solution(int[] sides) {
		int answer = 0;

		// 오름차순 정렬
		sort(sides);

		int max = sides[1]; // 11
		int min = sides[0]; // 7

		int low_range = max - min; // 4
		int high_range = max + min; // 18

		// 5, 6, 7, 8, 9 / 10, 11, 12, 13, 14 / 15, 16, 17 = 13개
		// high_range - low_range = 14
		// >> - 1 = 13

		answer = high_range - low_range - 1;

		return answer;
	}
}