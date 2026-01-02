package com.study.algorithm.site.programmers.level_0;

import java.util.Scanner;

public class Main92 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
	}

	private static void solution(int n) {
		if (n % 2 == 0) {
			System.out.printf("%d is even", n);
		} else {
			System.out.printf("%d is odd", n);
		}
	}
}