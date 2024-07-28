package com.study.algorithm.book.ch01;

public class PracticeProblems {

	static int max4(int a, int b, int c, int d) {
		int max = a; // 최댓값

		if (b > max) {
			max = b;
		}

		if (c > max) {
			max = c;
		}

		if (d > max) {
			max = d;
		}

		return max;
	}

	static int min3(int a, int b, int c) {
		int min = a; // 최댓값

		if (b < min) {
			min = b;
		}

		if (c < min) {
			min = c;
		}

		return min;
	}

	static int min4(int a, int b, int c, int d) {
		int min
				= a; // 최댓값

		if (b < min) {
			min = b;
		}

		if (c < min) {
			min = c;
		}

		if (d < min) {
			min = d;
		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println(max4(1, 2, 3, 4));
		System.out.println(min3(1, 2, 3));
		System.out.println(min4(1, 2, 3, 4));
	}
}
