package com.study.algorithm.site.programmers.level_0;

import java.util.Arrays;

public class Main15 {

	public static void main(String[] args) {
		solution("3 + 5");
	}

	private static int solution(String my_string) {
		return Arrays.stream(my_string.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
	}
}
