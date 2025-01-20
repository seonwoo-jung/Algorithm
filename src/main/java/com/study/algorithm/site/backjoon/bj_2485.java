package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dis = new int[n];

		for (int i = 0; i < n; i++) {
			dis[i] = Integer.parseInt(br.readLine());
		}

		int gcd = 0;

		for (int i = 0; i < n - 1; i++) {
			int distance = Math.abs(dis[i] - dis[i + 1]);
			gcd = GCD(distance, gcd);
		}

		// 1번 방법
		System.out.println(Math.abs(dis[0] - dis[n - 1]) / gcd + 1 - n);

		// 2번 방법
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += ((dis[i] - dis[i - 1]) / gcd) - 1;
		}

		System.out.println("sum = " + sum);
	}

	private static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
}