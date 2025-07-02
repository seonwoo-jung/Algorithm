package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int result = A * B * C;

		int[] answer = new int[10];

		String[] split = String.valueOf(result).split("");
		for (int i = 0; i < split.length; i++) {
			int idx = Integer.parseInt(split[i]);
			answer[idx]++;
		}

		for (int i : answer) {
			System.out.println(i);
		}
	}
}
