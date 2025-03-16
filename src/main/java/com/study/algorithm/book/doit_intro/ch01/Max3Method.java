package com.study.algorithm.book.doit_intro.ch01;

public class Max3Method {
	private static int max3(int a, int b, int c) {
		int max = a; // 최댓값

		if (b > max) {
			max = b;
		}

		if (c > max) {
			max = c;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(max3(3, 2, 1));
		System.out.println(max3(3, 2, 2));
		System.out.println(max3(3, 1, 2));
		System.out.println(max3(3, 2, 3));
		System.out.println(max3(2, 1, 3));
		System.out.println(max3(3, 3, 2));
		System.out.println(max3(3, 3, 3));
		System.out.println(max3(2, 2, 3));
		System.out.println(max3(2, 3, 1));
		System.out.println(max3(2, 3, 2));
		System.out.println(max3(1, 3, 2));
		System.out.println(max3(2, 3, 3));
		System.out.println(max3(1, 2, 3));
	}
}
