package com.study.algorithm.book.doit_intro.ch01;

import java.util.Scanner;

import static java.lang.System.in;

public class TriangleLB {
	public static void main(String[] args) {
//        triangleLB();
//        triangleLU();
//        triangleRU();
		triangleRB();
	}

	private static void triangleLB() {
		Scanner stdIn = new Scanner(in);
		int n;

		System.out.println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다.");

		do {
			System.out.print("몇 단 삼각형입니까?: ");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void triangleLU() {
		Scanner stdIn = new Scanner(in);
		int n;

		System.out.println("왼쪽 위가 직각인 이등변삼각형을 출력합니다.");

		do {
			System.out.print("몇 단 삼각형입니까?: ");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void triangleRU() {
		Scanner stdIn = new Scanner(in);
		int n;

		System.out.println("오른쪽 위가 직각인 이등변삼각형을 출력합니다.");

		do {
			System.out.print("몇 단 삼각형입니까?: ");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (j == 0) {
					for (int k = 0; k < i; k++) {
						System.out.print(" ");
					}
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?
	private static void triangleRB() {
		Scanner stdIn = new Scanner(in);
		int n;

		System.out.println("오른쪽 아래가 직각인 이등변삼각형을 출력합니다.");

		do {
			System.out.print("몇 단 삼각형입니까?: ");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
