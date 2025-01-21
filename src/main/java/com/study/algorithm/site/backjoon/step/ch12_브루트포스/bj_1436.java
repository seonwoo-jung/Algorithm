package com.study.algorithm.site.backjoon.step.ch12_브루트포스;

import java.util.Scanner;

public class bj_1436 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int num = 666;
		int count = 1;

		while (count != n) {
			num++;

			// int형인 num을 String으로 변환한 뒤, "666"이란 문자열이 있는지 검사
			if (String.valueOf(num).contains("666")) {
				count++;
			}
		}

		return num;
	}
}