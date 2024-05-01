package com.study.algorithm.programmers.level_0;

import java.util.stream.Collectors;

public class Main22 {
	public static void main(String[] args) {
		System.out.println(solution2("cccCCC"));
	}

	/**
	 * flow
	 * <p>
	 * String -> char[] array
	 * 소문자일 경우 대문자로
	 * 대문자일 경우 소문자로
	 * char[] array -> String
	 */
	static String solution(String my_string) {

		char[] array = my_string.toCharArray();

		for (int i = 0; i < array.length; i++) {
			if (Character.isUpperCase(array[i])) {
				array[i] = Character.toLowerCase(array[i]);
			} else {
				array[i] = Character.toUpperCase(array[i]);
			}
		}

		return String.valueOf(array);
	}

	/**
	 * flow
	 * String -> IntStream
	 * IntStream -> Stream
	 * char -> String
	 * 소문자면 대문자로
	 * 대문자면 소문자로
	 * 결과를 합침
	 */

	static String solution2(String my_string) {
		return my_string.chars().mapToObj(x -> String.valueOf((char) (Character.isLowerCase(x) ?
						Character.toUpperCase(x)
						: Character.toLowerCase(x))))
				.collect(Collectors.joining());
	}
}
