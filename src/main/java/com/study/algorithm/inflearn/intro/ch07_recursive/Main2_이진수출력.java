package com.study.algorithm.inflearn.intro.ch07_recursive;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 이진수 출력(재귀)
 */
public class Main2_이진수출력 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
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
