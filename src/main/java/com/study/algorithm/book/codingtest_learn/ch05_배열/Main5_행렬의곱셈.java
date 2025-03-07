package com.study.algorithm.book.codingtest_learn.ch05_배열;

/**
 * 행렬의 곱셈
 */
public class Main5_행렬의곱셈 {

	public static void main(String[] args) {
		int[][] answer = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, answer[i][j]);
			}
		}
	}

	private static int[][] solution(int[][] arr1, int[][] arr2) {
		// arr1의 행과 열의 길이
		int r1 = arr1.length;
		int c1 = arr1[0].length;

		// arr2의 행과 열의 길이
		int r2 = arr2.length;
		int c2 = arr2[0].length;

		int[][] answer = new int[r1][c2];

		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				for (int k = 0; k < c1; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}
}
