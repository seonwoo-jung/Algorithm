package com.study.algorithm.site.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_5073 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] arr = new int[3];
		while (kb.hasNextInt()) {
			for (int i = 0; i < 3; i++) {
				arr[i] = kb.nextInt();
			}
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				return;
			}
			Arrays.sort(arr);
			if (arr[2] >= arr[0] + arr[1]) {
				System.out.println("Invalid");
				continue;
			}
			long count = Arrays.stream(arr).distinct().count();
			if (count == 3) {
				System.out.println("Scalene");
			} else if (count == 2) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Equilateral");
			}
		}
	}
}