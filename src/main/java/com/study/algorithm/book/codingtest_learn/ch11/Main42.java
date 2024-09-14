package com.study.algorithm.book.codingtest_learn.ch11;

import java.util.ArrayList;

public class Main42 {

	private static boolean[] visited;
	private static ArrayList<Integer>[] adjList;
	private static int N, answer;

	public static void main(String[] args) {
		System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
		System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
		System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
	}

	private static int solution(int n, int[][] wires) {
		N = n;
		answer = n - 1;

		adjList = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] wire : wires) {
			adjList[wire[0]].add(wire[1]);
			adjList[wire[1]].add(wire[0]);
		}

		visited = new boolean[n + 1];
		DFS(1);
		return answer;
	}

	private static int DFS(int now) {
		visited[now] = true;

		int sum = 0;

		for (int next : adjList[now]) {
			if (!visited[next]) {
				int cnt = DFS(next);
				answer = Math.min(answer, Math.abs(N - cnt * 2));
				sum += cnt;
			}
		}

		return sum + 1;
	}
}
