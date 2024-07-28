package com.study.algorithm.site.programmers.level_0;

import static java.util.Arrays.sort;

public class Main81 {
	public static void main(String[] args) {
		int[] arr = {9, -1, 0};
		int solution = solution(arr);
		System.out.println("solution = " + solution);
	}

	static int solution(int[] array) {
		int index = array.length / 2;
		sort(array);
		return array[index];
	}
}