package com.study.algorithm.personal.study;

import java.util.ArrayList;

/**
 * DFS
 */
public class Main34 {

	private static ArrayList<ArrayList<Integer>> adjList;
	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	public static void main(String[] args) {
		int[] result = solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 1, 5);

		for (int i : result) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		visited = new boolean[n + 1];
		visited[1] = true;
		answer = new ArrayList<>();
		DFS(1);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void DFS(int now) {
		visited[now] = true;
		answer.add(now);

		for (int next : adjList.get(now)) {
			if (!visited[next]) {
				DFS(next);
			}
		}
	}
}
