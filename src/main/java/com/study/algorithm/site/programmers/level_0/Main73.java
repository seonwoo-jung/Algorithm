package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main73 {

	public static void main(String[] args) {
		solution2("jaron");
	}

	static String solution(String my_string) {
		String[] answer = new String[my_string.length()];
		String[] split = my_string.split("");
		int index = 0;
		for (int i = split.length - 1; i > -1; i--) {
			answer[index++] = split[i];
		}
		return Arrays.stream(answer).collect(Collectors.joining());
	}

	static String solution2(String my_string) {
		StringBuilder sb = new StringBuilder();
		sb.append(my_string);
		sb.reverse();
		return sb.toString();
	}
}