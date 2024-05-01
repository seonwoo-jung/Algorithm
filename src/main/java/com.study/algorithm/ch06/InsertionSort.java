package com.study.algorithm.ch06;

import java.util.Scanner;

import static java.lang.System.in;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);

		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		insertionSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");

		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}

	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
}
