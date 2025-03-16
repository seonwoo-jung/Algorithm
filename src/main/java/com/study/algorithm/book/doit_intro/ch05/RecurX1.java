package com.study.algorithm.book.doit_intro.ch05;

import com.study.algorithm.book.doit_intro.ch04.IntStack;

import java.util.Scanner;

import static java.lang.System.in;

public class RecurX1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);

		System.out.print("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		recur(x);
	}

	private static void recur(int n) {
		IntStack s = new IntStack(n);

		while (true) {
			if (n > 0) {
				s.push(n);
				n = n - 1;
				continue;
			}

			if (s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}
}
