package com.study.algorithm.inflearn.intro.ch03_twopointers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 두 배열 합치기 (two pointers algorithm)
 */
public class Main1_두배열합치기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = kb.nextInt();
		}

		int m = kb.nextInt();

		int[] b = new int[m];

		for (int i = 0; i < m; i++) {
			b[i] = kb.nextInt();
		}

		ArrayList<Integer> solution = solution(n, m, a, b);
		System.out.println(solution);
	}

	private static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
		ArrayList<Integer> answer = new ArrayList<>();
		// 포인터
		int p1 = 0, p2 = 0;

		while (p1 < n && p2 < m) {
			if (a[p1] < b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}

		while (p1 < n) answer.add(a[p1++]);
		while (p2 < m) answer.add(b[p2++]);
		return answer;
	}
}
