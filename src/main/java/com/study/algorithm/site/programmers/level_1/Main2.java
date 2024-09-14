package com.study.algorithm.site.programmers.level_1;

import java.util.HashMap;

public class Main2 {
	public static void main(String[] args) {
		int[] solution = solution(
				new String[]{"may", "kein", "kain", "radi"},
				new int[]{5, 10, 1, 3},
				new String[][]{
						{"may", "kein", "kain", "radi"},
						{"may", "kein", "brin", "deny"},
						{"kon", "kain", "may", "coni"}
				});
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}

		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length; j++) {
				answer[i] += map.getOrDefault(photo[i][j], 0);
			}
		}

		return answer;
	}
}
