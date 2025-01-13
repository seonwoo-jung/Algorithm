package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 회장선거
 */
public class Main5_회장선거 {

	public static void main(String[] args){
		System.out.println(solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}

	private static String solution(String[] votes, int k) {
		Map<String, ArrayList<String>> map = new HashMap<>();
		Map<String, Integer> answer = new TreeMap<>();

		for (String x : votes) {
			String[] s = x.split(" ");
			map.putIfAbsent(s[1], new ArrayList<>());
			map.get(s[1]).add(s[0]);
		}

		for (String name: map.keySet()) {
			if (map.get(name).size() < k) continue;
			ArrayList<String> people = map.get(name);
			for (String s: people) {
				answer.put(s, answer.getOrDefault(s, 0) + 1);
			}
		}

		return answer.entrySet()
			.stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
			.map(Entry::getKey)
			.toArray(String[]::new)[0];
	}
}
