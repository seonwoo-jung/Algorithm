package com.study.algorithm.book.doit_intro.ch05;

import java.util.Scanner;

public class Hanoi {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반의 개수: ");
		int n = stdIn.nextInt();

		move(n, 1, 3);
	}

	private static void move(int no, int x, int y) {
		if (no > 1) {
			move(no - 1, x, 6 - x - y);

			System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);

			if (no > 1) {
				move(no - 1, 6 - x - y, y);
			}
		}
	}
}
