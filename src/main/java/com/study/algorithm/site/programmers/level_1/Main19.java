package com.study.algorithm.site.programmers.level_1;

import java.util.Scanner;

/**
 * 2016년
 */
public class Main19 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		String solution = solution(a, b);
		System.out.println("solution = " + solution);
	}

	private static String solution(int a, int b) {
		String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int count = -1;

		for (int i = 0; i < a - 1; i++) {
			count += months[i];
		}

		return day[(count + b) % 7];
	}
}
