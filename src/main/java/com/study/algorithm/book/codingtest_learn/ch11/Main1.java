package com.study.algorithm.book.codingtest_learn.ch11;

import java.util.ArrayList;

public class Main1 {

	private static ArrayList<Integer>[] adjList;

	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	public static void main(String[] args) {
		int[] result = solution(new int[][]{
			{1, 2},
			{2, 3},
			{3, 4},
			{4, 5}
		}, 1, 5);

		for (int i : result) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : graph) {
			adjList[edge[0]].add(edge[1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();
		dfs(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void dfs(int now) {
		visited[now] = true;
		answer.add(now);

		for (int next : adjList[now]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
