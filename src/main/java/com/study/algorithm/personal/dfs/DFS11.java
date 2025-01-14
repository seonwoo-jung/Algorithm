package com.study.algorithm.personal.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;
import static java.lang.System.in;

// 동전교환
public class DFS11 {

	static int n, m, answer = MAX_VALUE;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
		m = kb.nextInt();
//        sort(arr, reverseOrder());
		DFS(0, 0, arr);
		System.out.println(answer);
	}


	private static void BFS(int sum, Integer[] arr) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(sum);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + " : ");
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				if (x > m) return;
				if (x == m) {
					answer = min(answer, L);
				} else {
					for (int j = 0; j < n; j++) {
						System.out.printf(x + arr[j] + " ");
						Q.offer(x + arr[j]);
					}
				}
			}
			L++;
			System.out.println();
		}
	}

	private static void DFS(int L, int sum, Integer[] arr) {
		if (sum > m) return;
		if (L >= answer) return;
		if (sum == m) {
			answer = min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				System.out.println();
				DFS(L + 1, sum + arr[i], arr);
			}
		}
	}
}