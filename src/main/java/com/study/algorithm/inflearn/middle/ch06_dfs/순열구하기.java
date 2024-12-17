package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.Scanner;

/**
 * 순열구하기
 */
public class 순열구하기 {

	private static int[] pm, ch, arr;
	private static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // n개 중에서
		m = kb.nextInt(); // m개를 뽑는다
		arr = new int[n]; // 원소

		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		ch = new int[n]; // 원소 사용여부
		pm = new int[m]; // 원소 값
		DFS(0);
	}

	private static void DFS(int L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			// n번 가닥이 뻗는다
			for (int i = 0; i < n; i++) {
				// i번째 인덱스가 쓰이지 않았을 때
				if (ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}
}
