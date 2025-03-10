package com.study.algorithm.book.codingtest_learn.ch13_정렬;

import java.util.Arrays;

public class Main51 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
	}

	private static int[] solution(int[] arr1, int[] arr2) {
		int[] answer = new int[arr1.length + arr2.length];
		int idx = 0, lt = 0, rt = 0;

		while (arr1.length > lt && arr2.length > rt) {
			if (arr1[lt] > arr2[rt]) {
				answer[idx++] = arr2[rt];
				rt++;
			} else {
				answer[idx++] = arr1[lt];
				lt++;
			}
		}


		while (rt < arr2.length) {
			answer[idx++] = arr2[rt++];
		}
		while (lt < arr1.length) {
			answer[idx++] = arr1[lt++];
		}

		return answer;
	}
}
