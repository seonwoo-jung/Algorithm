package com.study.algorithm.site.backjoon.step.ch22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14888 {

	private static int[] number, oper;
	private static int N;
	private static int maxAnswer = Integer.MIN_VALUE, minAnswer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		oper = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < oper.length; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		DFS(1, number[0]);

		System.out.println(maxAnswer);
		System.out.println(minAnswer);
	}

	private static void DFS(int L, int sum) {
		if (L == N) {
			maxAnswer = Math.max(sum, maxAnswer);
			minAnswer = Math.min(sum, minAnswer);
		} else {
			for (int i = 0; i < oper.length; i++) {
				if (oper[i] > 0) {
					oper[i]--;
					DFS(L + 1, calculate(i, sum, number[L]));
					oper[i]++;
				}
			}
		}
	}

	private static int calculate(int idx, int a, int b) {
		int result = 0;
		switch (idx) {
			case 0: {
				result = a + b;
				break;
			}
			case 1: {
				result = a - b;
				break;
			}
			case 2: {
				result = a * b;
				break;
			}
			case 3: {
				result = a / b;
				break;
			}
		}
		return result;
	}
}