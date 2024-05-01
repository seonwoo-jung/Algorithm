package com.study.algorithm.ch02;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);

		out.print("요솟수: ");
		int num = stdIn.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		reverse(x);

		out.println(sumOf(x));

		out.println("요소를 역순으로 정렬했습니다.");
		out.println("x = " + Arrays.toString(x));
	}

	static int sumOf(int[] params) {
		int sum = 0;

		for (int i = 0; i < params.length; i++) {
			sum += params[i];
		}

		return sum;
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		out.println("a[" + idx1 + "]과 a[" + idx2 + "]를 교환합니다.");
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
		}
	}
}
