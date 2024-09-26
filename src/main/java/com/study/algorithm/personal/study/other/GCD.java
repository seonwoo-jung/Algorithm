package com.study.algorithm.personal.study.other;

import java.util.Scanner;

import static java.lang.System.in;

public class GCD {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		int gcd = GCD(a, b);
		System.out.println("gcd = " + gcd);
	}

	private static int GCD(int a, int b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}
}
