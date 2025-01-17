package com.study.algorithm.inflearn.middle.ch08_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1_최소비행료 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(solution(4, new int[][]{{0, 3, 59}, {2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
	}

	private static int solution(int n, int[][] flights, int s, int e, int k) {
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		int[] costs = new int[n];
		Arrays.fill(costs, 1000000000);

		for (int[] x : flights) {
			graph.get(x[0]).add(new int[]{x[1], x[2]});
		}

		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[]{s, 0});
		costs[s] = 0;
		int L = 0;

		while (!Q.isEmpty()) {
			int len = Q.size(); // 사이즈만큼 구하는게 레벨탐색하는 것
			for (int i = 0; i < len; i++) {
				int[] p = Q.poll();
				int now = p[0];
				int nowCost = p[1];

				for (int[] x : graph.get(now)) {
					int nxNode = x[0];
					int nxCost = x[1];
					if (nowCost + nxCost < costs[nxNode]) {
						costs[nxNode] = nowCost + nxCost;
						Q.offer(new int[]{nxNode, costs[nxNode]});
					}
				}
			}

			L++;

			if (L > k) {
				break;
			}
		}

		if (costs[e] == 1000000000) {
			return -1;
		} else {
			return costs[e];
		}
	}
}
