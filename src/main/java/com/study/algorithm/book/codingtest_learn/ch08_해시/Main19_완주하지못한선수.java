package com.study.algorithm.book.codingtest_learn.ch08_해시;

import java.util.HashMap;
import java.util.Map;

public class Main19_완주하지못한선수 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
	}

	private static String solution(String[] participant, String[] completion) {
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
