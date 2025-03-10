package com.study.algorithm.book.codingtest_learn.ch12_백트래킹;

import java.util.ArrayList;

public class Main43_합이10이되는조합구하기 {

	private static ArrayList<ArrayList<Integer>> result;
	private static int n;

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(2));
		System.out.println(solution(7));
	}

	private static ArrayList<ArrayList<Integer>> solution(int N) {
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

		for (int i = start; i <= n; i++) {
			if (sum + i <= 10) {
				ArrayList<Integer> list = new ArrayList<>(selectedNums);
				list.add(i);

				backtrack(sum + i, list, i + 1);
			}
		}
	}
}
