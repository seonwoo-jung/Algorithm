package com.study.algorithm.personal.study;

import java.util.*;

public class Main9 {

	public static void main(String[] args) {
		String[] solution = solution("EEESEEEEEENNNN");
		System.out.println("solution = " + Arrays.toString(solution));
	}

	private static String[] solution(String path) {
		List<String> answer = new ArrayList<>();
		char[] paths = path.toCharArray();
		Map<String, String> map = createDirMap();

		char dir = paths[0];

		for (int i = 0; i < paths.length - 5; i++) {
			for (int j = i + 1; j <= i + 5; j++) {
				if (paths[i] != paths[j] && dir != paths[j]) {
					dir = paths[j];
					answer.add(String.format("Time %d: Go straight %dm and turn %s", i, Math.abs(i - j) * 100, map.get(paths[i] + "" + paths[j])));
					break;
				}
			}
		}
		return answer.stream().map(String::valueOf).toArray(String[]::new);
	}

	private static Map<String, String> createDirMap() {
		Map<String, String> map = new HashMap<>();
		map.put("NW", "left");
		map.put("NE", "right");

		map.put("SW", "left");
		map.put("SE", "right");

		map.put("WN", "right");
		map.put("WE", "left");

		map.put("EN", "left");
		map.put("ES", "right");
		return map;
	}
}
