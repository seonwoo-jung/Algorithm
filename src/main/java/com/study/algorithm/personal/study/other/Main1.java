package com.study.algorithm.personal.study.other;

public class Main1 {

	public static void main(String[] args) {
		solution(10);
	}

	private static void solution(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
}
