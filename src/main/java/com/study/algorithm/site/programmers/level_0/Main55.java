package com.study.algorithm.site.programmers.level_0;

public class Main55 {

	public static void main(String[] args) {
		int[] arr = {0, 31, 24, 10, 1, 9};
		System.out.println(solution(arr));
	}

	static int solution(int[] numbers) {
		int max = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (max < numbers[i] * numbers[j]) {
					max = numbers[i] * numbers[j];
				}
			}
		}
		return max;
	}
}