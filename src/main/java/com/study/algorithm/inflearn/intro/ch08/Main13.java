package com.study.algorithm.inflearn.intro.ch08;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 섬나라 아일랜드(DFS)
 */
public class Main13 {

	private static int answer = 0, n;
	// 시계방향으로 여덞방향을 탐색한다.
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}

		solution(arr);

		System.out.println(answer);
	}

	private static void DFS(int x, int y, int[][] board) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 행 밖으로 벗어나지않고, 1일때만 뻗는다.
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
				board[nx][ny] = 0;
				DFS(nx, ny, board);
			}
		}
	}

	private static void solution(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 섬이 발견됐을경우
				if (board[i][j] == 1) {
					answer++;
					board[i][j] = 0; // 출발점은 0(바다)으로 바꾼다.
					DFS(i, j, board);
				}
			}
		}
	}
}
