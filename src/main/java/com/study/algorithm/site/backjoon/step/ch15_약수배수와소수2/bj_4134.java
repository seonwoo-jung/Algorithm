package com.study.algorithm.site.backjoon.step.ch15_약수배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_4134 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			long m = Long.parseLong(br.readLine());
			while (!isPrime(m)) {
				m++;
			}
			System.out.println(m);
		}
	}

	private static boolean isPrime(long n) {
		if (n == 0 || n == 1) return false;

		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}