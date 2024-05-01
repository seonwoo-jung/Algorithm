package com.study.algorithm.programmers.level_0;

import static java.lang.Math.max;
import static java.util.Arrays.sort;

public class Main45 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, -3, 4, -5};
		System.out.println(solution(numbers));
	}

	private static int solution(int[] numbers) {
		sort(numbers);
		return max(numbers[0] * numbers[1], numbers[numbers.length - 1] * numbers[numbers.length - 2]);
	}
}