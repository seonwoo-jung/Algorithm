package com.study.algorithm.book.ch05;

import java.util.Scanner;

import static java.lang.System.in;

public class Recur {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);

		System.out.print("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		recur(x);
	}

	private static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
}
