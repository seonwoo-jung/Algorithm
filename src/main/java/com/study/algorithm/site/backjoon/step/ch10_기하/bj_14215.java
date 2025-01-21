package com.study.algorithm.site.backjoon.step.ch10_기하;

import java.util.Arrays;
import java.util.Scanner;

public class bj_14215 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		Arrays.sort(arr);

		if (arr[2] >= arr[0] + arr[1]) {
			int result = arr[0] + arr[1];
			System.out.println(result + result - 1);
		} else {
			System.out.println(Arrays.stream(arr).sum());
		}
	}
}