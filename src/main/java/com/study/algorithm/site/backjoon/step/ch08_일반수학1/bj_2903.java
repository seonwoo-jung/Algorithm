package com.study.algorithm.site.backjoon.step.ch08_일반수학1;

import java.util.Scanner;

public class bj_2903 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		System.out.println((int) Math.pow(Math.pow(2, n) + 1, 2));
	}
}