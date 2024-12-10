package com.study.algorithm.inflearn.middle.ch01;

/**
 * 청소
 */
public class Main2 {
	public static void main(String[] args) {
		int k = 10;
		int[][] board = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0}
		};
		int[] solution = solution(board, k);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int[][] board, int k) {
		int[] answer = new int[2];
		int n = board.length;
		// dx, dy는 방향
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		// d는 이동하는 방향을 가리킴 (일종의 포인터)
		int x = 0, y = 0, d = 1, count = 0;

		// 한 번 반복시 1초가 흐른다.
		while (count < k) {
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 격자 밖이거나 가려는 지점이 장애물일 경우 회전한다.
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
				d = (d + 1) % 4;
				continue;
			}
			x = nx;
			y = ny;
		}

		answer[0] = x;
		answer[1] = y;
		return answer;
	}
}
