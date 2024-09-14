package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main27 {
	public static void main(String[] args) {
		String my_string = "people";
		System.out.println(solution2(my_string));
	}

	private static String solution(String my_string) {
		return stream(my_string.split("")).distinct().collect(Collectors.joining());
	}

	private static String solution2(String my_string) {
		String[] arr = my_string.split("");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(arr));

		String[] resultArr = linkedHashSet.toArray(new String[0]);

		for (String s : resultArr) {
			System.out.println("s = " + s);
		}

		return null;
	}
}
