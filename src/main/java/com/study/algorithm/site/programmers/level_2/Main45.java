package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main45 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("GRGLGRG")));
		System.out.println(Arrays.toString(solution("GRGRGRB")));
	}

	private static int[] solution(String command) {
		int x = 0, y = 0, idx = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			if (c == 'L') {
				idx = (idx + 3) % 4;
			} else if (c == 'R') {
				idx = (idx + 1) % 4;
			} else {
				if (c == 'G') {
					x += dx[idx];
					y += dy[idx];
				} else if (c == 'B') {
					x -= dx[idx];
					y -= dy[idx];
				}
			}
		}

		return new int[]{y, -x};
	}
}