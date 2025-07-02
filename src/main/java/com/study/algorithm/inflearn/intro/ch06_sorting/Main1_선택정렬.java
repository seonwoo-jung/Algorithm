package com.study.algorithm.inflearn.intro.ch06_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 선택정렬
 */
public class Main1_선택정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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