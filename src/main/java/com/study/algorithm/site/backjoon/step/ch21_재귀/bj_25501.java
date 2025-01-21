package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_25501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int[] result = isPalindrome(s);
			System.out.printf("%d %d\n", result[0], result[1]);
		}
	}

	public static int[] recursion(String s, int l, int r, int L) {
		if (l >= r) {
			return new int[]{1, L};
		} else if (s.charAt(l) != s.charAt(r)) {
			return new int[]{0, L};
		} else {
			return recursion(s, l + 1, r - 1, L + 1);
		}
	}

	public static int[] isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1, 1);
	}
}