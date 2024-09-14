package com.study.algorithm.inflearn.intro.ch08;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 최대점수 구하기
 */
public class Main3 {

	static int answer = Integer.MIN_VALUE, n, m;
	boolean flag = false;

	private static void DFS(int L, int sum, int time, int[] ps, int[] pt) {
		if (time > m) return;
		if (L == n) {
			answer = max(answer, sum);
		} else {
			DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
			DFS(L + 1, sum, time, ps, pt);
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt(); // 문제수
		m = kb.nextInt(); // 제한시간
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = kb.nextInt();
			b[i] = kb.nextInt();
		}
		DFS(0, 0, 0, a, b);
		System.out.println(answer);
	}
}
