package com.study.algorithm.book.codingtest_learn.ch08_해시;

import java.util.HashSet;

public class Main18_두개의수로특정값만들기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
	}

	private static boolean solution(int[] arr, int target) {
		HashSet<Integer> hashSet = new HashSet<>();

		for (int i : arr) {

			if (hashSet.contains(target - i)) {
				return true;
			}

			hashSet.add(i);
		}

		return false;
	}
}
