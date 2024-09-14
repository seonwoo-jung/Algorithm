package com.study.algorithm.site.programmers.level_0;

import static java.util.Arrays.stream;

public class Main38 {

	public static void main(String[] args) {
		int solution = solution("1 2 Z 3");
		System.out.println("solution = " + solution);
	}

	private static int solution(String s) {
		String[] strArray = s.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equals("Z")) {
				strArray[i] = "0";
				strArray[i - 1] = "0";
			}
		}

		return stream(strArray).mapToInt(Integer::valueOf).sum();
	}
}
