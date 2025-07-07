package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_15829 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		long r = 1;
		long sum = 0;
		int mod = 1234567891;

		for (int i = 0; i < L; i++) {
			int index = arr[i] - 'a' + 1;
			sum = (sum + (index * r) % mod) % mod;
			r = (r * 31) % mod;
		}

		System.out.println(sum);
	}
}
