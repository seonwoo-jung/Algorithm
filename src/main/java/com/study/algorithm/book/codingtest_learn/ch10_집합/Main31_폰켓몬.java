package com.study.algorithm.book.codingtest_learn.ch10_집합;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main31_폰켓몬 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
	}

	private static int solution(int[] nums) {
		HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

		int n = nums.length;

		int k = n / 2;

		return Math.min(k, set.size());
	}
}
