package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 모임 장소
 */
public class Main5 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
		System.out.println(solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
		System.out.println(solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					row.add(i);
					col.add(j);
				}
			}
		}

		Collections.sort(col);

		int x = row.get(row.size() / 2);
		int y = col.get(col.size() / 2);
		for (int p : row) answer += Math.abs(x - p);
		for (int p : col) answer += Math.abs(y - p);

		return answer;
	}
}
