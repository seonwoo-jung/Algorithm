package com.study.algorithm.book.ch05;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Factorial {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);

		out.print("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		out.println(x + "의 팩토리얼은 " + fact(x) + "입니다.");
	}

	private static int factorial(int n) {
		if (n > 0) {
			return n * factorial(n - 1);
		} else {
			return 1;
		}
	}

	private static int fact(int n) {
		for (int i = n - 1; i > 0; i--) {
			n *= i;
		}
		return n;
	}
}
