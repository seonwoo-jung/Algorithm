package com.study.algorithm.inflearn.intro.ch02;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 보이는 학생
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(solution(n, arr));
	}

	private static int solution(int n, int[] arr) {
		int answer = 1, max = arr[0];

		for (int i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
				answer++;
			}
		}
		return answer;
	}
}