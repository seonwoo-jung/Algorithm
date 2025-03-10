package com.study.algorithm.book.codingtest_learn.ch14_시뮬레이션;

import java.util.Arrays;

public class Main59_배열회전하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));
	}

	private static int[][] solution(int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			arr = rotate90(arr);
		}

		return arr;
	}

	private static int[][] rotate90(int[][] arr) {
		int n = arr.length;
		int[][] rotatedArr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotatedArr[j][n - i - 1] = arr[i][j];
			}
		}

		return rotatedArr;
	}
}
