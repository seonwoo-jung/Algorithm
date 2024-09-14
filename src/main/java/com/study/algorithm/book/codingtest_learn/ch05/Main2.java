package com.study.algorithm.book.codingtest_learn.ch05;

import java.util.Arrays;
import java.util.Collections;

/**
 * 배열 제어하기
 */
public class Main2 {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[]{4, 2, 2, 1, 3, 4});
		int[] answer2 = solution(new int[]{2, 1, 1, 3, 2, 5, 4});

		System.out.println("answer1 = " + Arrays.toString(answer1));
		System.out.println("answer2 = " + Arrays.toString(answer2));
	}

	private static int[] solution(int[] arr) {
		Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
		Arrays.sort(result, Collections.reverseOrder());
		return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
	}
}
