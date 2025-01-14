package com.study.algorithm.inflearn.intro.ch02_array;

import java.util.Scanner;

/**
 * 등수 구하기
 */
public class Main8_등수구하기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		int[] solution = solution(n, arr);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int n, int[] arr) {
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n; j++) {
				if (arr[j] > arr[i]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}
}