package com.study.algorithm.inflearn.intro.ch10;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 계단 오르기
 */
public class Main1 {

	static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		// 계단의 수
		int n = kb.nextInt();
		dy = new int[n + 1];
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;

		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i - 2] + dy[i - 1];
		}

		return dy[n];
	}
}
