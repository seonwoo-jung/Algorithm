package com.study.algorithm.site.backjoon;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;

public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		solution(arr);
	}

	private static void solution(int[][] arr) {
		int x = 0, y = 0, max = MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", x + 1, y + 1);
	}
}
