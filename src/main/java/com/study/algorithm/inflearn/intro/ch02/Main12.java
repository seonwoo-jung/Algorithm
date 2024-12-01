package com.study.algorithm.inflearn.intro.ch02;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 멘토링
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
		// 멘토 선택
		for (int i = 1; i <= n; i++) {
			// 멘티 선택
			for (int j = 1; j <= n; j++) {
				// 테스트 통과 횟수
				int cnt = 0;
				// 시험 선택
				for (int k = 0; k < m; k++) {
					int pi = 0, pj = 0;
					// 학생 순위
					for (int s = 0; s < n; s++) {
						if (arr[k][s] == i) pi = s;
						if (arr[k][s] == j) pj = s;
					}
					// 멘토와 멘티 조건 검증
					if (pi < pj) {
						cnt++;
					}
				}
				// 멘토링 가능성 +1
				if (cnt == m) {
					answer++;
				}
			}
		}
		return answer;
	}
}