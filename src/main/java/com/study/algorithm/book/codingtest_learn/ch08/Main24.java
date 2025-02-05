package com.study.algorithm.book.codingtest_learn.ch08;

import java.util.*;

public class Main24 {

	private static HashMap<Integer, HashMap<String, Integer>> courseMap;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				new int[]{2, 3, 4})));
	}

	private static String[] solution(String[] orders, int[] course) {
		courseMap = new HashMap<>();

		for (int i : course) {
			courseMap.put(i, new HashMap<>());
		}

		for (String order : orders) {
			char[] orderArray = order.toCharArray();
			Arrays.sort(orderArray);
			combinations(0, orderArray, "");
		}

		ArrayList<String> answer = new ArrayList<>();

		for (HashMap<String, Integer> count : courseMap.values()) {
			count.values()
				.stream()
				.max(Comparator.comparingInt(o -> o))
				.ifPresent(cnt -> count.entrySet().stream().filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
				.forEach(entry -> answer.add(entry.getKey())));
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	private static void combinations(int idx, char[] order, String result) {
		if (courseMap.containsKey(result.length())) {
			HashMap<String, Integer> map = courseMap.get(result.length());
			map.put(result, map.getOrDefault(result, 0) + 1);
		}

		for (int i = idx; i < order.length; i++) {
			combinations(i + 1, order, result + order[i]);
		}
	}
}
