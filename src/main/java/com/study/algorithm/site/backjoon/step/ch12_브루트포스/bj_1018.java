package com.study.algorithm.site.backjoon.step.ch12_브루트포스;

import java.util.Scanner;

public class bj_1018 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = kb.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int minRepaint = Integer.MAX_VALUE;

		// 가능한 모든 8x8 부분보드 순회
		for (int startRow = 0; startRow <= N - 8; startRow++) {
			for (int startCol = 0; startCol <= M - 8; startCol++) {
				// 두 패턴에 대해 다시 칠해야 하는 수를 계산
				int repaintPattern1 = 0; // 왼쪽 위가 W인 패턴
				int repaintPattern2 = 0; // 왼쪽 위가 B인 패턴

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						char current = board[startRow + i][startCol + j];
						// (i + j)가 짝수인 경우와 홀수인 경우에 따라 체스판 패턴이 달라짐
						boolean isEven = (i + j) % 2 == 0;

						// 패턴1: (왼쪽 위 W)
						// 짝수 칸: W, 홀수 칸: B
						if (isEven) {
							if (current != 'W') repaintPattern1++;
						} else {
							if (current != 'B') repaintPattern1++;
						}

						// 패턴2: (왼쪽 위 B)
						// 짝수 칸: B, 홀수 칸: W
						if (isEven) {
							if (current != 'B') repaintPattern2++;
						} else {
							if (current != 'W') repaintPattern2++;
						}
					}
				}

				// 두 패턴 중 더 적게 칠하는 경우 선택
				int localMin = Math.min(repaintPattern1, repaintPattern2);
				minRepaint = Math.min(minRepaint, localMin);
			}
		}

		System.out.println(minRepaint);
	}
}