package com.study.algorithm.ch02;

import java.util.Random;

public class MaxOfArrayRand {

	public static void main(String[] args) {
		Random rand = new Random();

		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");

		int[] height = new int[rand.nextInt(30)];

		System.out.println("킷값은 아래와 같습니다.");

		for (int i = 0; i < height.length; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "]: " + height[i]);
		}

		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}

	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
}