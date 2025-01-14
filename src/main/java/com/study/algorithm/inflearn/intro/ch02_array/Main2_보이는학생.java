package com.study.algorithm.inflearn.intro.ch02_array;

import java.util.Scanner;

/**
 * 보이는 학생
 */
public class Main2_보이는학생 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(solution(n, arr));
	}

	private static int solution(int n, int[] arr) {
		int h = Integer.MIN_VALUE;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > h) {
				h = arr[i];
				answer++;
			}
		}
		return answer;
	}
}