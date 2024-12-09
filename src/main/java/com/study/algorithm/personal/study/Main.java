package com.study.algorithm.personal.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while (true) {
			int n = kb.nextInt();
			if (n == -1) return;

			List<Integer> list = new ArrayList<>();
			int answer = 0;

			for (int i = 1; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					list.add(i);
					answer += i;
					if (i != 1 && i != n / i) {
						list.add(n / i);
						answer += n / i;
					}
				}
			}

			if (answer == n) {
				list.sort(Integer::compareTo); // 약수를 오름차순으로 정렬
				System.out.printf("%d = %s\n", n, String.join(" + ", list.stream().map(String::valueOf).toArray(String[]::new)));
			} else {
				System.out.printf("%d is NOT perfect.\n", n);
			}
		}
	}
}