package com.study.algorithm.inflearn.intro.ch02;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 멘토링 (이해필요)
 */
public class Main12 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();

		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		int solution = solution(n, m, arr);
		System.out.println(solution);
	}

	private static int solution(int n, int m, int[][] arr) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int cnt = 0;
				for (int k = 0; k < m; k++) {
					int pi = 0, pj = 0;
					for (int s = 0; s < n; s++) {
						if (arr[k][s] == i) pi = s;
						if (arr[k][s] == j) pj = s;
					}
					if (pi < pj) cnt++;
				}
				if (cnt == m) {
					answer++;
				}
			}
		}
		return answer;
	}
}