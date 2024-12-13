package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 서로 다른 빈도수 만들기
 */
public class Main3 {

	public static void main(String[] args) {
		System.out.println(solution("aaabbbcc"));
		System.out.println(solution("aaabbc"));
		System.out.println(solution("aebbbbc"));
		System.out.println(solution("aaabbbcccde"));
		System.out.println(solution("aaabbbcccdddeeeeeff"));
	}

	private static int solution(String s) {
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		for (char key : map.keySet()) {
			while (set.contains(map.get(key))) {
				answer++;
				map.put(key, map.get(key) - 1);
			}

			if (map.get(key) == 0) {
				continue;
			}
			set.add(map.get(key));
		}
		return answer;
	}
}
