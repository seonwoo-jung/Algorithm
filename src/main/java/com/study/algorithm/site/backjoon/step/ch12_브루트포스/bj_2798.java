package com.study.algorithm.site.backjoon.step.ch12_브루트포스;

import java.util.Scanner;

public class bj_2798 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum <= m) {
						answer = Math.max(sum, answer);
					}
				}
			}
		}
		System.out.println(answer);
	}
}