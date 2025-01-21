package com.study.algorithm.site.backjoon.other;

import java.util.Scanner;

public class bj_2580 {

	private static int[][] arr;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = kb.nextInt();
			}
		}

		solution(0, 0);
	}

	public static void solution(int row, int col) {
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if (col == 9) {
			solution(row + 1, 0);
			return;
		}

		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			// 출력 뒤 시스템을 종료한다.
			System.exit(0);
		}

		// 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if (possibility(row, col, i)) {
					arr[row][col] = i;
					solution(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}

		solution(row, col + 1);
	}

	public static boolean possibility(int row, int col, int value) {

		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}

		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}

		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치

		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}

		return true; // 중복되는 것이 없을 경우 true 반환
	}
}
