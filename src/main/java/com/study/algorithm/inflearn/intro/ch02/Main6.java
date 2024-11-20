package com.study.algorithm.inflearn.intro.ch02;

import static java.lang.System.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 뒤집은 소수 9 32 55 62 20 250 370 200 30 100
 */
public class Main6 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		List<Integer> data = solution2(n, arr);
		System.out.println("data = " + data);
	}

	private static List<Integer> solution2(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = new StringBuilder(String.valueOf(arr[i])).reverse().toString();
			int res = Integer.parseInt(str);

			if (isPrime(res)) {
				answer.add(res);
			}
		}
		return answer;
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
			if (isPrime(res)) {
				answer.add(res);
			}
		}
		return answer;
	}

	private static boolean isPrime(int num) {
		// 1은 소수가 아님
		if (num == 1) {
			return false;
		}

		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}