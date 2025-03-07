package com.study.algorithm.book.codingtest_learn.ch05.recommend;

import java.util.Arrays;

public class Main2_배열뒤집기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1, 1, 2})));
		System.out.println(Arrays.toString(solution(new int[]{1, 0, 1, 1, 1, 3, 5})));
	}

	public static int[] solution(int[] num_list) {
		int[] reverse = new int[num_list.length];
		int N = num_list.length - 1;

		for (int i = 0; i < num_list.length; i++) {
			reverse[i] = num_list[N - i];
		}

		return reverse;
	}
}
