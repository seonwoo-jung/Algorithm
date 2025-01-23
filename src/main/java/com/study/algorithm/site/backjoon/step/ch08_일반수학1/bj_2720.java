package com.study.algorithm.site.backjoon.step.ch08_일반수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int q = 25, d = 10, n = 5, p = 1;

		for (int i = 0; i < T; i++) {
			int c = Integer.parseInt(br.readLine());
			System.out.print(c / q + " ");
			c = c % q;
			System.out.print(c / d + " ");
			c = c % d;
			System.out.print(c / n + " ");
			c = c % n;
			System.out.println(c / p);
		}
	}
}
