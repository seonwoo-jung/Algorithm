package com.study.algorithm.site.programmers.level_0;

import java.util.Scanner;

public class Main76 {

	// BMI 공식: kg * (m * m)
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		System.out.printf("%d\n", n * n);
		if (n < 5) {
			System.out.println("tiny");
		}
	}
}