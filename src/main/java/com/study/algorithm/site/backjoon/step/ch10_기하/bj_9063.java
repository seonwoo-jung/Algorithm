package com.study.algorithm.site.backjoon.step.ch10_기하;

import java.util.Scanner;

public class bj_9063 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			minX = Math.min(x, minX);
			minY = Math.min(y, minY);
			maxX = Math.max(x, maxX);
			maxY = Math.max(y, maxY);
		}
		int x = Math.abs(minX - maxX);
		int y = Math.abs(minY - maxY);
		System.out.println(x * y);
	}
}