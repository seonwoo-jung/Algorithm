package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 한 번 사용한 최초문자
 */
public class Main1_한번사용한최초문자 {

	public static void main(String[] args) {
		String s1 = "statitsics";
		String s2 = "aabb";
		String s3 = "stringshowtime";
		String s4 = "abcdeabcdfg";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
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
