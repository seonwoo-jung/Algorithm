package com.study.algorithm.site.backjoon.step.ch23_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카데인 알고리즘
 */
public class bj_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = Math.max(arr[i], sum + arr[i]);
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}