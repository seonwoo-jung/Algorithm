package com.study.algorithm.programmers.level_1;

public class Main30 {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 2},
				{2, 3}};
		int[][] arr2 = {{3, 4},
				{5, 6}};
		int[][] solution = solution(arr1, arr2);
		for (int[] ints : solution) {
			for (int anInt : ints) {
				System.out.println("anInt = " + anInt);
			}
		}
	}

	static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
}