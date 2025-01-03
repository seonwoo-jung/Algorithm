package com.study.algorithm.inflearn.intro.ch07_recursive;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 팩토리얼
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int dfs = DFS(n);
		System.out.println("dfs = " + dfs);
	}

	private static int DFS(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * DFS(n - 1);
		}
	}
}
