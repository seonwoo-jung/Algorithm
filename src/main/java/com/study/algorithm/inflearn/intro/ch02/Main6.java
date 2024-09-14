package com.study.algorithm.inflearn.intro.ch02;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 뒤집은 소수
 * 9
 * 32 55 62 20 250 370 200 30 100
 */
public class Main6 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		ArrayList<Integer> data = solution(n, arr);
		System.out.println("data = " + data);
	}

	private static ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int tmp = arr[i];
			int res = 0;
			while (tmp > 0) {
				// 일의 자리를 하나씩 뽑아내기
				int t = tmp % 10;
				res = res * 10 + t;
				tmp = tmp / 10;
			}
			if (isPrime(res)) answer.add(res);
		}
		return answer;
	}

	private static boolean isPrime(int num) {
		// 1은 소수가 아님
		if (num == 1) return false;
		for (int i = 2; i < num; i++) {
			// 2부터 num 전까지의 수로 나눠지지 않으면 소수임
			if (num % i == 0) return false;
		}
		return true;
	}
}