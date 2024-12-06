package com.study.algorithm.personal.study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[100][100];
		for (int i = 0; i < n; i++) {
			int row = kb.nextInt();
			int col = kb.nextInt();
			for (int j = row; j < row + 10; j++) {
				for (int k = 0; k < col + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
	}
}