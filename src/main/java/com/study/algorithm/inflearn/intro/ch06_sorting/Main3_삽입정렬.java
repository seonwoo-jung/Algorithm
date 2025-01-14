package com.study.algorithm.inflearn.intro.ch06_sorting;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 삽입정렬 (손안의 카드를 정렬하는 방법과 유사)
 */
public class Main3_삽입정렬 {
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
		for (int i = 1; i < n; i++) {
			int tmp = arr[i], j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tmp;
		}

		return arr;
	}
}
