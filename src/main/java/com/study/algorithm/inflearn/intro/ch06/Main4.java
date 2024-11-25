package com.study.algorithm.inflearn.intro.ch06;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * LRU
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int s = kb.nextInt();
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		int[] solution = solution(s, n, arr);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int s, int n, int[] arr) {
		int[] cache = new int[s];
		for (int x : arr) {
			int pos = -1;
			//
			for (int i = 0; i < s; i++) {
				if (x == cache[i]) {
					pos = i;
				}
			}
			// cache miss
			if (pos == -1) {
				for (int i = s - 1; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
				// cache hit
			} else {
				for (int i = pos; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
			}
			cache[0] = x;
		}
		return cache;
	}
}
