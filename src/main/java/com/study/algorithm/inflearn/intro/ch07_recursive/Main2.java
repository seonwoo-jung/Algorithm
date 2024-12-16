package com.study.algorithm.inflearn.intro.ch07_recursive;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 이진수 출력(재귀)
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		DFS(n);
	}

	private static void DFS(int n) {
		if (n != 0) {
			DFS(n / 2);
			System.out.print(n % 2 + " ");
		}
	}
}
