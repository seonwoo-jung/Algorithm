package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1940_주몽의명령 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(arr);

		int lt = 0;
		int rt = arr.length - 1;
		int answer = 0;

		while (lt < rt) {
			int sum = arr[lt] + arr[rt];
			if (sum == M) {
				answer++;
				lt++;
				rt--;
			} else if (sum > M) {
				rt--;
			} else {
				lt++;
			}
		}

		System.out.println(answer);
	}
}
