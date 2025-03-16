package com.study.algorithm.book.doit_intro.ch03;

import java.util.Scanner;

import static java.lang.System.in;

public class SeqSearchSen {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(in);

		System.out.print("요솟수: ");

		int num = stdIn.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		System.out.print("검색할 값: ");
		int ky = stdIn.nextInt();

		int idx = seqSearch(x, num, ky);

		if (idx == -1) {
			System.out.println("그 값은 요소가 없습니다.");
		} else {
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		}
	}

	private static int seqSearch(int[] a, int n, int key) {

		a[n] = key;

		for (int j = 0; j < a.length; j++) {
			if (a[j] == key) {
				return j;
			}
		}
		return -1;
	}
}
