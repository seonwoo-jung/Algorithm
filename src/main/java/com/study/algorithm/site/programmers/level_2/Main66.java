package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main66 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{6, 10, 2}));
		System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
	}

	private static String solution(int[] numbers) {
		String[] array = Arrays
			.stream(numbers).boxed()
			.map(String::valueOf)
			.sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
			.toArray(String[]::new);

		if (array[0].equals("0")) return "0";

		return Arrays.stream(array).collect(Collectors.joining());
	}
}
