package com.study.algorithm.inflearn.ch08;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 미로탐색
 */
public class Main10 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	static int answer = 0;

	static void DFS(int x, int y) {
		if (x == 7 && y == 7) {
			answer++;
		} else {
			// 네개의 방향
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 1. 경계선 밖에 있는지 확인한다.
				// 2. 갈 수 있는 통로인지 확인한다.
				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					DFS(nx, ny);
					board[nx][ny] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		board = new int[8][8];
		for (int i = 1; i < board.length; i++)
			for (int j = 1; j < board.length; j++)
				board[i][j] = kb.nextInt();

		board[1][1] = 1;
		DFS(1, 1);
		System.out.println("answer = " + answer);
	}
}
