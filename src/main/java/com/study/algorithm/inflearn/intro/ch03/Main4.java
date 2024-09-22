package com.study.algorithm.inflearn.intro.ch03;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 연속 부분수열
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		// 배열 사이즈
		int n = kb.nextInt();
		// 연속된 수
		int m = kb.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		int solution = solution2(n, m, arr);
		System.out.println("solution = " + solution);
	}

	// n: 배열 사이즈, k: 연속된 수
	private static int solution(int n, int m, int[] arr) {
		int answer = 0;
		for (int i = 0; i < n - 1; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == m) {
					answer++;
					break;
				}
			}
		}
		return answer;
	}

	private static int solution2(int n, int m, int[] arr) {
		int answer = 0, sum = 0, lt = 0;

		for (int rt = 0; rt < n; rt++) {
			sum += arr[rt];
			if (sum == m) answer++;
			while (sum >= m) {
				sum -= arr[lt++];
				if (sum == m) answer++;
			}
		}

		return answer;
	}
}
