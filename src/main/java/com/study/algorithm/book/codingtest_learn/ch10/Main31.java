package com.study.algorithm.book.codingtest_learn.ch10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main31 {

	private static int[] parent;

	public static void main(String[] args) {
		int solution = solution(new int[]{3, 1, 2, 3});
		int solution1 = solution(new int[]{3, 3, 3, 2, 2, 4});
		int solution2 = solution(new int[]{3, 3, 3, 2, 2, 2});

		System.out.println("solution = " + solution);
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
	}

	private static int solution(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
		int k = nums.length / 2;
		return Math.min(k, set.size());
	}

	private static int solution2(int[] nums) {
		return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length / 2);
	}
}
