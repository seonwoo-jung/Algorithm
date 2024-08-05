package com.study.algorithm.site.programmers.level_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 완주하지 못한 선수
 */
public class Main60 {

	public static void main(String[] args) {
		// 테스트 케이스 1
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		solution(participant1, completion1);

		// 테스트 케이스 2
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		solution(participant2, completion2);

		// 테스트 케이스 3
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		solution(participant3, completion3);
	}

	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : participant) {
			int cnt = map.getOrDefault(s, 0);
			map.put(s, cnt + 1);
		}

		for (String s : completion) {
			if (map.containsKey(s)) {
				int cnt = map.get(s);
				map.put(s, cnt - 1);
			}
		}

		return map.entrySet().stream()
			.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
	}
}
