package com.study.algorithm.site.backjoon.step.ch12_브루트포스;

import java.util.Scanner;

// 가감법
public class bj_19532 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		int d = kb.nextInt();
		int e = kb.nextInt();
		int f = kb.nextInt();

		System.out.print((c * e - b * f) / (a * e - b * d) + " ");
		System.out.print((c * d - a * f) / (b * d - a * e) + "");
	}
}