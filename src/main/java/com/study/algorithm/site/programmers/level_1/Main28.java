package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;

import static java.util.Collections.reverseOrder;

public class Main28 {

	public static void main(String[] args) {
		String solution = solution("Zbcdefg");
		System.out.println(solution);
	}

	private static String solution(String s) {
		String answer = "";

		String[] str = s.split("");
		Arrays.sort(str, reverseOrder());

		for (String a : str)
			answer += a;

		return answer;
	}
}
