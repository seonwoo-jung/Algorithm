package com.study.algorithm.site.backjoon.step.ch15_약수배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_4948 {

	private static int[] ch = new int[246913];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getPrime();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			int answer = 0;

			for (int i = n + 1; i <= 2 * n; i++) {
				if (ch[i] == 0) answer++;
			}

			System.out.println(answer);
		}
	}

	public static void getPrime() {
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