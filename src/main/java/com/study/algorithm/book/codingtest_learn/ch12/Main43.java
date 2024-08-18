package com.study.algorithm.book.codingtest_learn.ch12;

import java.util.ArrayList;

public class Main43 {

	private static ArrayList<ArrayList<Integer>> result;
	private static int n;

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> solution = solution(5);
//		ArrayList<ArrayList<Integer>> solution1 = solution(2);
//		ArrayList<ArrayList<Integer>> solution2 = solution(7);

		System.out.println("solution = " + solution);
//		System.out.println("solution1 = " + solution1);
//		System.out.println("solution2 = " + solution2);
	}

	static ArrayList<ArrayList<Integer>> solution(int N) {
		result = new ArrayList<>();
		n = N;

		backtrack(0, new ArrayList<>(), 1);
		return result;
	}

	private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
		if (sum == 10) {
			result.add(selectedNums);
			return;
		}

		System.out.println("selectedNums = " + selectedNums);

		for (int i = start; i <= n; i++) {
			if (sum + i <= 10) {
				ArrayList<Integer> list = new ArrayList<>(selectedNums);
				list.add(i);

				backtrack(sum + i, list, i + 1);
			}
		}
	}
}
