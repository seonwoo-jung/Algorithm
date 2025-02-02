package com.study.algorithm.personal.sorting;

import java.util.Arrays;

/**
 * 자리를 선택해 들어갈 원소를 정한다.
 */
public class 선택정렬 {

	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		System.out.println(Arrays.toString(solution(arr.length, arr)));
	}

	private static int[] solution(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[idx]) idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
}