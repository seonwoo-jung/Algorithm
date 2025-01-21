package com.study.algorithm.site.backjoon.step.ch10_기하;

import java.util.Scanner;

public class bj_1085 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int x = kb.nextInt();
		int y = kb.nextInt();
		int w = kb.nextInt();
		int h = kb.nextInt();

		int dis1 = Math.abs(w - x);
		int dis2 = Math.abs(h - y);
		int dis3 = y;
		int dis4 = x;

		int minDis1 = Math.min(dis1, dis2);
		int minDis2 = Math.min(dis3, dis4);

		System.out.println(Math.min(minDis1, minDis2));
	}
}