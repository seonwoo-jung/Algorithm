package com.study.algorithm.site.programmers.level_1;

/**
 * 프로그래머스 - 이웃한 칸
 */
public class Main61 {

	public static void main(String[] args) {
		int solution = solution(new String[][]{
			{"blue", "red", "orange", "red"},
			{"red", "red", "blue", "orange"},
			{"blue", "orange", "red", "red"},
			{"orange", "orange", "red", "blue"}
		}, 1, 1);
		int solution1 = solution(
			new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"},
				{"yellow", "blue", "blue"}}, 0, 1);
		System.out.println("solution = " + solution);
		System.out.println("solution1 = " + solution1);
	}

	private static int solution(String[][] board, int h, int w) {
		int answer = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		String color = board[h][w];
		int n = board.length;

		for (int i = 0; i < 4; i++) {
			int nx = h + dx[i];
			int ny = w + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (board[nx][ny].equals(color)) {
				answer++;
			}
		}

		return answer;
	}
}
