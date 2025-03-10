package com.study.algorithm.book.codingtest_learn.ch11_그래프;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * BFS
 */
public class Main35_BFS {

	private static ArrayList<Integer>[] adjList;

	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}}, 1, 9)));
	}

	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList[n + 1];

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : graph) {
			adjList[edge[0]].add(edge[1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();
		BFS(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void BFS(int start) {
		ArrayDeque<Integer> Q = new ArrayDeque<>();
		Q.add(start);
		visited[start] = true;

		while (!Q.isEmpty()) {
			int now = Q.poll();
			answer.add(now);
			for (int next : adjList[now]) {
				if (!visited[next]) {
					Q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
