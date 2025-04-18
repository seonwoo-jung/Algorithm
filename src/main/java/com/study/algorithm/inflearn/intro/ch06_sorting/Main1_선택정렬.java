package com.study.algorithm.inflearn.intro.ch06_sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 선택정렬
 */
public class Main1_선택정렬 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		System.out.println(Arrays.toString(solution(n, arr)));
	}

	private static int[] solution(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[idx]) {
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
}