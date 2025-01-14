package com.study.algorithm.inflearn.intro.ch03_twopointers;

import static java.lang.Math.max;

import java.util.Scanner;

/**
 * 최대 매출(Sliding window)
 */
public class Main3_최대매출 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt(); // 배열 사이즈
		int k = kb.nextInt(); // 연속된 일수

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		int solution = solution(n, k, arr);
		System.out.println("solution = " + solution);
	}

	// n: 배열 사이즈, k: 연속된 일수
	private static int solution(int n, int k, int[] arr) {
		int answer, sum = 0;

		// 0부터 k번 째 전까지 합한다.
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		answer = sum;

		// arr[0] + arr[1] + arr[2]와 arr[1] + arr[2] + arr[3] 비교 후 큰 값을 answer에 입력
		for (int i = k; i < n; i++) {
			sum += (arr[i] - arr[i - k]);
			answer = max(answer, sum);
		}

		return answer;
	}
}
