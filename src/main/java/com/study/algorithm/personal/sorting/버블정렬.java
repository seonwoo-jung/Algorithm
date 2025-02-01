package com.study.algorithm.personal.sorting;

import java.util.Arrays;

public class 버블정렬 {

	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		System.out.println(Arrays.toString(solution(arr.length, arr)));
	}

	// 버블정렬 (이웃한 두 수를 비교)
	// 한 번의 Turn으로 제일 큰 수를 맨 뒤로 보내고, 다음 반복 때는 결정된 자리 전까지 반복함.
	private static int[] solution(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}
}