package com.study.algorithm.personal.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS
 */
public class Main34 {

	private static ArrayList<ArrayList<Integer>> adjList;
	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	public static void main(String[] args) {
		int[] result = solution2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 1, 5);

		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : graph) {
			adjList.get(edge[0]).add(edge[1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();
		DFS(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] solution2(int[][] graph, int start, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : graph) {
			adjList.get(edge[0]).add(edge[1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();
		BFS(start);

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

	private static void BFS(int start) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(start);
		visited[start] = true;

		while (!Q.isEmpty()) {
			int now = Q.poll();
			answer.add(now);

			for (int next : adjList.get(now)) {
				Q.offer(next);
				visited[next] = true;
			}
		}
	}
}
