package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main70 {

	private static final HashMap<Character, int[]> location = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}

	private static int solution(String dirs) {
		initLocation();
		int x = 5, y = 5;
		Set<String> answer = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			int[] direction = location.get(dirs.charAt(i));
			int nx = x + direction[0];
			int ny = y + direction[1];

			if (!isValidMove(nx, ny)) {
				continue;
			}

			answer.add(x + " " + y + " " + nx + " " + ny);
			answer.add(nx + " " + ny + " " + x + " " + y);

			x = nx;
			y = ny;
		}

		return answer.size() / 2;
	}

	private static boolean isValidMove(int nx, int ny) {
		return nx >= 0 && nx < 11 && ny >= 0 && ny < 11;
	}

	private static void initLocation() {
		location.put('U', new int[]{0, 1});
		location.put('D', new int[]{0, -1});
		location.put('L', new int[]{-1, 0});
		location.put('R', new int[]{1, 0});
	}
}