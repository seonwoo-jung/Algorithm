package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 한 번 사용한 최초문자
 */
public class Main1_한번사용한최초문자 {

	public static void main(String[] args) {
		System.out.println(solution("statitsics"));
		System.out.println(solution("aabb"));
		System.out.println(solution("stringshowtime"));
		System.out.println(solution("abcdeabcdfg"));
	}

	private static int solution(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i + 1;
			}
		}

		return -1;
	}
}
