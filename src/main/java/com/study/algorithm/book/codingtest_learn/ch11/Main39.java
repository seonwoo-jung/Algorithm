package com.study.algorithm.book.codingtest_learn.ch11;

import java.util.HashSet;
import java.util.Set;

public class Main39 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int row;
	static int col;
	static int answer = Integer.MAX_VALUE;
	static String[] map;
	static int lever = 0;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
//		int result = solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
		int result2 = solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"});
//		System.out.println("result = " + result);
		System.out.println("result2 = " + result2);
	}

	static int solution(String[] maps) {

		row = maps.length;
		col = maps[0].length();
		map = maps;

		int curX = 0, curY = 0;

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == 'S') {
					curX = i;
					curY = j;
				}
			}
		}
		set.add(curX + " " + curY);

		return DFS(curX, curY, 1);
	}

	static int DFS(int x, int y, int sum) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx].charAt(ny) != 'X'
				&& !set.contains(nx + " " + ny)) {
				if (map[nx].charAt(ny) == 'L') {
					lever = 1;
				} else if (map[nx].charAt(ny) == 'E') {
					if (lever == 1) {
						return answer = Math.min(answer, sum);
					}
				}
				set.add(nx + " " + ny);
				DFS(nx, ny, sum + 1);
				lever = 0;
			}
		}
		return -1;
	}
}
