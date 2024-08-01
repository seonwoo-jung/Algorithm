package com.study.algorithm.book.codingtest_learn.ch01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 개 뽑아서 더하기
 */
public class Main3 {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[]{2, 1, 3, 4, 1});
		int[] answer2 = solution(new int[]{5, 0, 2, 7});

		System.out.println("answer1 = " + Arrays.toString(answer1));
		System.out.println("answer2 = " + Arrays.toString(answer2));
	}

	static int[] solution(int[] arr) {
		Set<Integer> answer = new HashSet<>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				answer.add(arr[i] + arr[j]);
			}
		}

		return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
}
