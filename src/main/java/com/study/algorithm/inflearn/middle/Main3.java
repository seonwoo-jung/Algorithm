package com.study.algorithm.inflearn.middle;

/**
 * 잃어버린 강아지
 */
public class Main3 {
	public static void main(String[] args) {
		int[][] arr1 = {
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
		};
		System.out.println(solution(arr1));

		int[][] arr2 = {
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
		};
		System.out.println(solution(arr2));
	}

	static int solution(int[][] board) {
		int n = board.length;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				// 현수 위치 찾기
				if (board[i][j] == 2) {
					x1 = i;
					y1 = j;
				}

				// 강아지 위치 찾기
				if (board[i][j] == 3) {
					x2 = i;
					y2 = j;
				}
			}
		}

		// d1은 현수 방향, d2는 강아지 방향
		int d1 = 0, d2 = 0, count = 0;

		while (count < 10000) {
			count++;

			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];

			// 회전 유무
			boolean flag1 = true, flag2 = true;

			// 현수가 지도 바깥쪽 또는 나무를 만나면 회전
			if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4;
				flag1 = false;
			}

			// 강아지가 지도 바깥쪽 또는 나무를 만나면 회전
			if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4;
				flag2 = false;
			}

			// 현수는 회전하지 않음
			if (flag1 == true) {
				x1 = nx1;
				y1 = ny1;
			}

			// 강아지는 회전하지 않음
			if (flag2 == true) {
				x2 = nx2;
				y2 = ny2;
			}

			// 현수와 강아지가 만남
			if (x1 == x2 && y1 == y2) break;
		}

		if (count >= 10000) return 0;

		return count;
	}
}
