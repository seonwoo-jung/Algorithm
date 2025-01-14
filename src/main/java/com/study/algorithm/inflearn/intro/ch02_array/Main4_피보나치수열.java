package com.study.algorithm.inflearn.intro.ch02_array;

import java.util.Scanner;

/**
 * 피보나치 수열
 */
public class Main4_피보나치수열 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		int[] result = solution(n);
		for (int a : result) {
			System.out.println("a = " + a);
		}
	}

	private static int[] solution(int n) {
		int[] answer = new int[n];

		answer[0] = 1;
		answer[1] = 1;

		for (int i = 2; i < n; i++) {
			answer[i] = answer[i - 2] + answer[i - 1];
		}

		return answer;
	}
}