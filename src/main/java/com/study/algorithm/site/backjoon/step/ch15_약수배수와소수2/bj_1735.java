package com.study.algorithm.site.backjoon.step.ch15_약수배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1735 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int A = Integer.parseInt(s1[0]);
		int B = Integer.parseInt(s1[1]);

		int C = Integer.parseInt(s2[0]);
		int D = Integer.parseInt(s2[1]);

		int numerator = A * D + C * B;
		int denominator = B * D;

		int mod = GCD(numerator, denominator);

		numerator /= mod;
		denominator /= mod;

		System.out.printf("%d %d", numerator, denominator);
	}

	private static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
}