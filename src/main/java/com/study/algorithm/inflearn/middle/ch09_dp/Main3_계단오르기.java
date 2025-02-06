package com.study.algorithm.inflearn.middle.ch09_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] score = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution(n, score));
	}

	private static int solution(int n, int[] score) {
		int[] dy = new int[n + 1];
		dy[1] = score[1];

		if (n > 1) {
			dy[2] = score[1] + score[2];
		}

		for (int i = 3; i <= n; i++) {
			dy[i] = Math.max(dy[i - 2] + score[i], dy[i - 3] + score[i - 1] + score[i]);
		}

		return dy[n];
	}
}
