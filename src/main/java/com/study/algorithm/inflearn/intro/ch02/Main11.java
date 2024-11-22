package com.study.algorithm.inflearn.intro.ch02;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;

/**
 * 임시 반장 정하기
 */
public class Main11 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();

		int[][] arr = new int[n + 1][6];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(solution(n, arr));
	}

	private static int solution(int n, int[][] arr) {
		int answer = 0, max = MIN_VALUE;
		// 한 명의 학생을 선택
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			// 다른 학생들과의 비교
			for (int j = 1; j <= n; j++) {
				// 학년을 선택
				for (int k = 1; k <= 5; k++) {
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			// 최대값 비교 및 결과 저장
			if (cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		return answer;
	}
}