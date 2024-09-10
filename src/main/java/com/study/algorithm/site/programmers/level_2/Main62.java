package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.Comparator;

public class Main62 {

	private static int[] parent;

	public static void main(String[] args) {
		System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
	}

	private static int solution(int n, int[][] costs) {
		int answer = 0;

		Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int edges = 0;

		for (int[] edge : costs) {
			if (edges == n - 1) {
				break;
			}

			if (find(edge[0]) != find(edge[1])) {
				union(edge[1], edge[0]);
				answer += edge[2];

				edges++;
			}
		}

		return answer;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		int root1 = find(x);
		int root2 = find(y);
		parent[root2] = root1;
	}
}