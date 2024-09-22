package com.study.algorithm.inflearn.intro.ch08;

import static java.lang.System.in;

import java.util.Scanner;

public class Main1 {

	private static String answer = "NO";
	private static int n, total = 0;
	private static boolean flag = false;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		DFS(0, 0, arr);
		System.out.println(answer);
	}

	private static void DFS(int L, int sum, int[] arr) {
		if (flag) return;            // 부분집합 합을 찾으면 더 찾을 필요가 없음.
		if (sum > total / 2) return; // 총합보다 크다면 재귀가 돌아갈 필요가 없음
		if (L == n) {
			// -sum 대신 /2로 해도 됨
			if ((total - sum) == sum) {
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(L + 1, sum + arr[L], arr);
			DFS(L + 1, sum, arr);
		}
	}
}
