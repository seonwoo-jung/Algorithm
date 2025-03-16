package com.study.algorithm.book.doit_intro.ch05;

import java.util.Scanner;

import static java.lang.System.in;

public class RecurMemo {
	static String[] memo;

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(in);
		System.out.print("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		// 배열 초기화
		memo = new String[x + 2];
		recur(x);
	}

	private static void recur(int n) {
		if (memo[n + 1] != null) {
			System.out.print(memo[n + 1]);
		} else {
			if (n > 0) {
				recur(n - 1);
				System.out.println(n);
				recur(n - 2);
				memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
			} else {
				memo[n + 1] = "";
			}
		}
	}
}
