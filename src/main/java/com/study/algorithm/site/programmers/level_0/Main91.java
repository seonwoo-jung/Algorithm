package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;

/**
 * 평행
 */
public class Main91 {
	public static void main(String[] args) {
		System.out.println(solution2(new int[] {3, 4, 5, 2, 1}));
		System.out.println(solution2(new int[] {5, 7, 8, 3}));
	}

	private static int solution(int[] num_list) {
		int alpha = 1;
		for (int i = 0; i < num_list.length; i++) {
			alpha *= num_list[i];
		}
		int beta = 0;
		for (int i = 0; i < num_list.length; i++) {
			beta += num_list[i];
		}
		int pow = (int)Math.pow(beta, 2);
		return alpha < pow ? 1 : 0;
	}

	private static int solution2(int[] num_list) {
		// acc의 첫 값 = 스트림의 첫 번째 요소
		return (Arrays.stream(num_list).reduce((acc, i) -> acc * i).getAsInt() < Math.pow(Arrays.stream(num_list).sum(), 2)) ? 1 : 0;
	}
}