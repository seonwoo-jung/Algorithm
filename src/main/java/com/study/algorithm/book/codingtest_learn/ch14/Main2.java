package com.study.algorithm.book.codingtest_learn.ch14;

public class Main2 {

	public static void main(String[] args) {
		int[][] result1 = solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
		int[][] result2 = solution(new int[][]{{2, 4, 6}, {1, 3, 5}, {7, 8, 9}}, new int[][]{{9, 1, 2}, {4, 5, 6}, {7, 3, 8}});

		for (int[] ints : result1) {
			for (int anInt : ints) {
				System.out.println("anInt = " + anInt);
			}
		}
	}

	static int[][] solution(int[][] matrix1, int[][] matrix2) {
		int[][] multiplied = multiplyMatrices(matrix1, matrix2);

		// 전치 행렬 생성
		int[][] transposed = transposeMatrix(multiplied);

		return transposed;
	}

	private static int[][] transposeMatrix(int[][] matrix) {
		int[][] result = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result[j][i] = matrix[i][j];
			}
		}

		return result;
	}

	private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
		int[][] result = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					result[i][j] += (matrix1[i][k] * matrix2[k][j]);
				}
			}
		}

		return result;
	}
}
