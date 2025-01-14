package com.study.algorithm.personal.dfs;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 합이 같은 부분집합
 */
public class DFS7 {

	static int answer = MIN_VALUE, n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // 문제개수
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

	private static void DFS(int L, int sum, int time, int[] ps, int[] pt) {
		if (time > m) return;
		if (L == n) {
			answer = max(answer, sum);
		} else {
			DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
			DFS(L + 1, sum, time, ps, pt);
		}
	}


//    static void DFS(int L, int score, int time) {
//
//        if (time > m) return; // 제한시간 초과는 뻗지 않는다.
//
//        if (L == n) {
//            answer = Math.max(answer, score);
//            return;
//        } else {
//            for (Example x : arr) {
//                DFS(L + 1, score + x.s, time + x.t);
//                DFS(L + 1, score, time);
//            }
//        }
//    }

	static class Example {
		private int s, t;

		public Example(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
}
