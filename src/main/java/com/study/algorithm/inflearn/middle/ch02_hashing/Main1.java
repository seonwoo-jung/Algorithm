package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 한 번 사용한 최초문자
 */
public class Main1 {

	public static void main(String[] args) {
		String s1 = "statitsics";
		String s2 = "aabb";
		String s3 = "stringshowtime";
		String s4 = "abcdeabcdfg";
		System.out.println(solution2(s1));
		System.out.println(solution2(s2));
		System.out.println(solution2(s3));
		System.out.println(solution2(s4));
	}

	private static int solution(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);

			if (!set.contains(x) && i == s.lastIndexOf(x)) {
				return i + 1;
			} else {
				set.add(x);
			}
		}
		return -1;
	}

	private static int solution2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		System.out.println("map = " + map);
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i + 1;
			}
		}

		return -1;
	}
}
