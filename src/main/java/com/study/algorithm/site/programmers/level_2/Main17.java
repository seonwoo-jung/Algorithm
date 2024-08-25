package com.study.algorithm.site.programmers.level_2;

import java.util.HashSet;
import java.util.Set;

public class Main17 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
	}

	private static int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++) {
					sum += elements[k % elements.length];
				}
				System.out.println("i = " + i + " j = " + j);
				System.out.println("sum = " + sum);
				set.add(sum);
			}
		}

		return set.size();
	}
}
