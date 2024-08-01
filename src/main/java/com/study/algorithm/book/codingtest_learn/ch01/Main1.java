package com.study.algorithm.book.codingtest_learn.ch01;

import java.util.Arrays;

/**
 * 배열 정렬하기
 */
public class Main1 {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[]{1, -5, 2, 4, 3});
		int[] answer2 = solution(new int[]{2, 1, 1, 3, 2, 5, 4});
		int[] answer3 = solution(new int[]{6, 1, 7});

		int[] arr1 = answer1.clone();
		int[] arr2 = answer2.clone();
		int[] arr3 = answer3.clone();

		System.out.println("answer1 = " + Arrays.toString(answer1));
		System.out.println("answer3 = " + Arrays.toString(answer2));
		System.out.println("answer2 = " + Arrays.toString(answer3));
	}

	static int[] solution(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
}
