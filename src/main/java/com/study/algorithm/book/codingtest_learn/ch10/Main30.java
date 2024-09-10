package com.study.algorithm.book.codingtest_learn.ch10;

import java.util.ArrayList;
import java.util.Arrays;

public class Main30 {

	private static int[] parent;

	public static void main(String[] args) {
		Boolean[] solution1 = solution(3, new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 1, 2}});
		Boolean[] solution2 = solution(4, new int[][]{{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}});
		System.out.println(Arrays.toString(solution1));
		System.out.println(Arrays.toString(solution2));
	}

	private static Boolean[] solution(int k, int[][] operation) {
		parent = new int[k];

		for (int i = 0; i < k; i++) {
			parent[i] = i;
		}

		ArrayList<Boolean> answer = new ArrayList<>();

		for (int[] op : operation) {
			if (op[0] == 0) {
				union(op[1], op[2]);
			} else {
				answer.add(find(op[1]) == find(op[2]));
			}
		}
		return answer.toArray(Boolean[]::new);
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}

	private static void union(int x, int y) {
		int root1 = find(x);
		int root2 = find(y);
		parent[root2] = root1;
	}
}
