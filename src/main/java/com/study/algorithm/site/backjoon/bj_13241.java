package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_13241 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long a = Long.parseLong(s[0]);
		long b = Long.parseLong(s[1]);
		long result = a * b / GCD(a, b);
		System.out.println(result);
	}

	private static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
}