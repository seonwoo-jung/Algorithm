package com.study.algorithm.personal.study;

import java.util.Scanner;

import static java.lang.System.in;

public class CalculatePrime {

	static int[] ch = new int[1000000];

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int solution = solution(n);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		int answer = 0;

		for (int i = 2; i <= n; i++) {
			if (ch[i] == 0) {
				answer++;
				for (int j = i; j <= n; j = i + j) {
					if (ch[j] == 0) ch[j] = 1;
				}
			}
		}

		return answer;
	}

	static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2) return true;

		if (ch[num] == 0) {
			ch[num] = 1;
			for (int i = 0; i < num; i++) {

			}
		}

		return true;
	}
}
