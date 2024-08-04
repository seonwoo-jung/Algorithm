package com.study.algorithm.book.codingtest_learn.ch08;

import java.util.HashMap;
import java.util.Map;

public class Main19 {

	public static void main(String[] args) {
		String result = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
		System.out.println("result = " + result);
	}

	static String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();
		for (String string : completion) {
			map.put(string, map.getOrDefault(string, 0) + 1);
		}

		for (String string : participant) {
			if(map.getOrDefault(string, 0) == 0) {
				return string;
			}
			map.put(string, map.get(string) - 1);
		}

		return null;
	}
}
