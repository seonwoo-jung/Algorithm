package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main60 {

	private static int[] parent;

	public static void main(String[] args) {
		int[] solution = solution(new int[]{0, 1, 2, 7, 6, 2, 1, 2, 6, 3}, 9);
		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(int[] arr, int k) {
		parent = arr;

		for (int i = 0; i < parent.length; i++) {
			find(i);
		}

		return parent;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
}