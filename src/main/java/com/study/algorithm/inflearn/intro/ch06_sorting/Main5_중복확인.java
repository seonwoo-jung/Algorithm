package com.study.algorithm.inflearn.intro.ch06_sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 중복 확인
 */
public class Main5_중복확인 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		String solution = solution2(n, arr);
		System.out.println("solution = " + solution);
	}

	private static String solution2(int n, int[] arr) {
		String answer = "U";
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) return "D";
		}
		return answer;
	}

	private static String solution(int n, int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int x : arr) {
			set.add(x);
		}
		return set.size() == n ? "U" : "D";
	}
}
