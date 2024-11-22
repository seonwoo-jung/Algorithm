package com.study.algorithm.inflearn.intro.ch03;

import java.util.Scanner;

import static java.lang.System.in;

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

		int solution = solution(n, m, arr);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n, int m, int[] arr) {
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
