package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1929 {

	private static int[] ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		ch = new int[n + 1];
		getPrime();

		for (int i = m; i <= n; i++) {
			if (ch[i] == 0) {
				System.out.println(i);
			}
		}
	}

	public static void getPrime() {
		// true = 소수아님 , false = 소수
		ch[0] = 1;
		ch[1] = 1;

		for (int i = 2; i <= Math.sqrt(ch.length); i++) {
			if (ch[i] == 1) {
				continue;
			}

			for (int j = i * i; j < ch.length; j += i) {
				ch[j] = 1;
			}
		}
	}
}