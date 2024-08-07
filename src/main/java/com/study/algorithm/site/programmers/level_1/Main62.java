package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;

/**
 * 프로그래머스 - 체육복
 */
public class Main62 {

	public static void main(String[] args) {
		int solution = solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
		int solution1 = solution(5, new int[]{2, 4}, new int[]{3});
		int solution2 = solution(3, new int[]{3}, new int[]{1});
		System.out.println("solution = " + solution);
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n + 2];

		// 모두 1로 초기화
		for (int i = 1; i <= n; i++) {
			student[i] = 1;
		}
		System.out.println(Arrays.toString(student));

		// 해당 값 2로 초기화
		for (int x : reserve) {
			student[x] = 2;
		}
		System.out.println(Arrays.toString(student));

		// 해당 값 0으로 초기화
		for (int x : lost) {
			if (student[x] == 2) {
				student[x] = 1;
			} else {
				student[x] = 0;
			}
		}
		System.out.println(Arrays.toString(student));

		for (int i = 1; i <= n; i++) {
			if (student[i] == 0) {
				if (student[i - 1] == 2) {
					student[i - 1] = 1;
					student[i] = 1;
				} else if (student[i + 1] == 2) {
					student[i + 1] = 1;
					student[i] = 1;
				}
			}
		}

		return (int) Arrays.stream(student).filter(x -> x > 0).count();
	}
}
