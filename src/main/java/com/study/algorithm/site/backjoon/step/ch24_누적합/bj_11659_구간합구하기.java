package com.study.algorithm.site.backjoon.step.ch24_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * i에서 j까지 구간합 공식: S[j] - S[i - 1]
 */
public class bj_11659_구간합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + arr[i - 1];
		}

		for (int i = 0; i < M; i++) {
			String[] strings = br.readLine().split(" ");
			int start = Integer.parseInt(strings[0]);
			int end = Integer.parseInt(strings[1]);
			System.out.println(sum[end] - sum[start - 1]);
		}
	}
}