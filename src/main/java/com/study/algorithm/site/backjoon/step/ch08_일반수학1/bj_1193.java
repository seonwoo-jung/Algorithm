package com.study.algorithm.site.backjoon.step.ch08_일반수학1;

import java.util.Scanner;

public class bj_1193 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int X = kb.nextInt();

		int diagonal = 1, previous_sum = 0;

		while (X > previous_sum) {
			previous_sum += diagonal;
			diagonal++;
		}

		diagonal--; // 마지막에 1 더해졌으므로 다시 빼줌

		int position = X - (previous_sum - diagonal); // 대각선 내에서의 위치

		if (diagonal % 2 == 1) {
			// 홀수 대각선: 분자 감소, 분모 증가
			System.out.println((diagonal - position + 1) + "/" + position);
		} else {
			// 짝수 대각선: 분자 증가, 분모 감소
			System.out.println(position + "/" + (diagonal - position + 1));
		}
	}
}
