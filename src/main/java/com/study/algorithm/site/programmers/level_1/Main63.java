package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스
 */
public class Main63 {

	public static void main(String[] args) {
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
	}

	public static String solution(String X, String Y) {
		String answer = "";
		Map<Character, Integer> map = new HashMap<>();

		for (char x : Y.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		char[] array = X.toCharArray();
		Arrays.sort(array);
		StringBuilder tmp = new StringBuilder(new String(array));
		String sortedStr = tmp.reverse().toString();

		StringBuilder sb = new StringBuilder();

		for (char x : sortedStr.toCharArray()) {
			int count = map.getOrDefault(x, 0);
			if (count > 0) {
				sb.append(x);
				map.put(x, count - 1);
			}
		}

		if (sb.toString().isEmpty()) {
			return "-1";
		} else if (sb.toString().charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}
}
