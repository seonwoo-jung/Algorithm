package com.study.algorithm.site.backjoon.step.ch11_시간복잡도;

import java.util.Scanner;

public class bj_24262 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		long n = kb.nextLong();
		System.out.println((n * (n - 1) * (n - 2) / 6) + "\n" + 3);
	}
}