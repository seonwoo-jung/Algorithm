package com.study.algorithm.other.study;

import java.util.Scanner;

public class Combi {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int r = kb.nextInt();
		int result = DFS(n, r);
		System.out.println("result = " + result);
	}

	static int DFS(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		} else {
			return DFS(n - 1, r - 1) + DFS(n - 1, r);
		}
	}
}
