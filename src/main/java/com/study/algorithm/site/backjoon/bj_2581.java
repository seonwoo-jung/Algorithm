package com.study.algorithm.site.backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_2581 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int m = kb.nextInt();
		int n = kb.nextInt();
		List<Integer> list = new ArrayList<>();
		int answer = 0;

		for (int i = m; i <= n; i++) {
			if (isPrime(i)) {
				list.add(i);
				answer += i;
			}
		}
		if (list.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
			System.out.println(Collections.min(list));
		}
	}

	private static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}