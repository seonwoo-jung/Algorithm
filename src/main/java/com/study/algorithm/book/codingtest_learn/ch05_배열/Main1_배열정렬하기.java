package com.study.algorithm.book.codingtest_learn.ch05_배열;

import java.util.Arrays;

/**
 * 배열 정렬하기
 */
public class Main1_배열정렬하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
		System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
		System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
	}

	private static int[] solution(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
}
