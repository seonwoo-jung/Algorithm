package com.study.algorithm.book.codingtest_learn.ch10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main31 {

	private static int[] parent;

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
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
