package com.study.algorithm.site.backjoon.step.ch15_약수배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17103 {

	private static int[] ch = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		getPrime();

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			for (int j = 2; j <= n / 2; j++) {
				if (ch[j] == 0 && ch[n - j] == 0) answer++;
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