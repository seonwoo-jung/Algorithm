package com.study.algorithm.book.codingtest_learn.ch05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 방문 길이
 */
public class Main7_방문길이 {

	private static final HashMap<Character, int[]> location = new HashMap<>();

	public static void main(String[] args) {
		int answer1 = solution("ULURRDLLU");
		int answer2 = solution("LULLLLLLU");
		System.out.println("answer = " + answer1);
		System.out.println("answer = " + answer2);
	}

	private static void initLocation() {
		location.put('U', new int[]{0, 1});
		location.put('D', new int[]{0, -1});
		location.put('L', new int[]{-1, 0});
		location.put('R', new int[]{1, 0});
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
}
