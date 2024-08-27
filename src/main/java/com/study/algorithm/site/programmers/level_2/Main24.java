package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Main24 {

	public static void main(String[] args) {
		System.out.println(solution(
			7,
			10,
			new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7},
				{6, 7}},
			6,
			new int[]{1, 2, 3, 3, 6, 7}));
	}

	private static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;
		List<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < edge_list.length; i++) {
			graph.get(edge_list[i][0]).add(edge_list[i][1]);
		}

		A: for (int i = 0; i < gps_log.length; i++) {
			for (int nx : graph.get(gps_log[i])) {
				if (nx == gps_log[i]) {
					continue A;
				}
			}
			answer++;
		}

		return answer;
	}
}
