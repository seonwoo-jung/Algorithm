package com.study.algorithm.site.backjoon.step.ch08_일반수학1;

import java.util.Scanner;

public class bj_2869 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int up = kb.nextInt();		// A
		int down = kb.nextInt();	// B
		int length = kb.nextInt(); 	// C

		int day = (length - down) / (up - down);

		if ((length - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}
}