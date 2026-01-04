package com.study.algorithm.site.programmers.level_0;

import java.util.Scanner;

public class Main96 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(solution(a, b));
	}

	private static String solution(String a, String b) {
		return a + b;
	}
}