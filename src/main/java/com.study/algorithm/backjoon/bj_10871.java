package com.study.algorithm.backjoon;

import java.util.Scanner;

public class bj_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp < x) {
				System.out.printf("%d ", tmp);
			}
		}
	}
}
