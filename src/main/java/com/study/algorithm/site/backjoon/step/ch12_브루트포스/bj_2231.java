package com.study.algorithm.site.backjoon.step.ch12_브루트포스;

import java.util.Scanner;

public class bj_2231 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int result = 0;

		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;    // 각 자릿수 합 변수

			while (number != 0) {
				sum += number % 10;    // 각 자릿수 더하기
				number /= 10;
			}

			// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
			if (sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}