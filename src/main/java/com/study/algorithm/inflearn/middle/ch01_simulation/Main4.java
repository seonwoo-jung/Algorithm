package com.study.algorithm.inflearn.middle.ch01_simulation;

import java.util.Arrays;

/**
 * 좌석 번호
 */
public class Main4 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 5, 12)));
		System.out.println(Arrays.toString(solution(6, 5, 20)));
		System.out.println(Arrays.toString(solution(6, 5, 30)));
		System.out.println(Arrays.toString(solution(6, 5, 31)));
	}

	private static int[] solution(int c, int r, int k) {
		int[] answer = new int[2];

		// c * r == 총 앉을 수 있는 좌석 수
		if (k > c * r) return new int[]{0, 0};

		int[][] seat = new int[c][r];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		int x = 0, y = 0, count = 1, d = 1;

		while (count < k) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
				d = (d + 1) % 4;
				continue;
			}
			k--;
			seat[x][y] = count;
			count++;
			x = nx;
			y = ny;
		}

		answer[0] = x + 1;
		answer[1] = y + 1;

		return answer;
	}
}
