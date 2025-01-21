package com.study.algorithm.site.backjoon.step.ch10_기하;

import java.util.Scanner;

public class bj_10101 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();

		if (a + b + c != 180) {
			System.out.println("Error");
		} else if (a == b && a == c) {
			System.out.println("Equilateral");
		} else if (a == b || a == c || b == c) {
			System.out.println("Isosceles");
		} else {
			System.out.println("Scalene");
		}
	}
}