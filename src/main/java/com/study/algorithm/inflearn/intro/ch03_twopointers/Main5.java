package com.study.algorithm.inflearn.intro.ch03_twopointers;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 연속된 자연수의 합 (two pointers)
 */
public class Main5 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		int n = kb.nextInt();

		int solution = solution(n);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n) {
		int answer = 0, sum = 0, lt = 0;
		int m = n / 2 + 1;
		int[] arr = new int[m];

		for (int i = 0; i < m; i++) {
			arr[i] = i + 1;
		}

		for (int rt = 0; rt < m; rt++) {
			sum += arr[rt];
			if (sum == n) answer++;
			while (sum >= n) {
				sum -= arr[lt++];
				if (sum == n) answer++;
			}
		}

		return answer;
	}
}
