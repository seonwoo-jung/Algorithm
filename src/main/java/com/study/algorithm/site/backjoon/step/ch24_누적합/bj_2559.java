package com.study.algorithm.site.backjoon.step.ch24_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int sum = 0;

		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		int answer = sum;

		for (int i = K; i < N; i++) {
			answer = Math.max(answer, sum);
			sum = sum - arr[i - K] + arr[i];
		}

		System.out.println(answer);
	}
}