package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_30802 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] bundle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int tshirtBundles = 0;

		for (int count : arr) {
			tshirtBundles += (count + bundle[0] - 1) / bundle[0];  // 올림 나눗셈
		}

		// 펜 계산
		int penBundles = N / bundle[1];
		int remainingPens = N % bundle[1];

		// 출력
		System.out.println(tshirtBundles);
		System.out.printf("%d %d", penBundles, remainingPens);
	}
}
