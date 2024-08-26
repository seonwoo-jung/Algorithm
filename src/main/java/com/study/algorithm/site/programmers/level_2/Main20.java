package com.study.algorithm.site.programmers.level_2;

public class Main20 {

	public static void main(String[] args) {

//		int[][] solution = solution(
//			new int[][]{{1, 4}, {3, 2}, {4, 1}},
//			new int[][]{{3, 3}, {3, 3}}
//		);
//		for (int i = 0; i < solution.length; i++) {
//			for (int j = 0; j < solution[i].length; j++) {
//				System.out.printf("%d ", solution[i][j]);
//			}
//			System.out.println();
//		}

		int[][] solution2 = solution(
			new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
			new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}
		);
		for (int i = 0; i < solution2.length; i++) {
			for (int j = 0; j < solution2[i].length; j++) {
				System.out.printf("%d ", solution2[i][j]);
			}
			System.out.println();
		}
	}

	private static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < arr1[0].length; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = sum;
			}
		}
		return answer;
	}
}
