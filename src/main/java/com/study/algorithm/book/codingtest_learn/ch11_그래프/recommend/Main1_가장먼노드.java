package com.study.algorithm.book.codingtest_learn.ch11_그래프.recommend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1_가장먼노드 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
	}

	private static int solution(int n, int[][] edge) {
		int answer = 0;
		int N = n + 1;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] distance = new int[N];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] ints : edge) {
			graph.get(ints[0]).add(ints[1]);
			graph.get(ints[1]).add(ints[0]);
		}

		boolean[] visited = new boolean[N];
		visited[1] = true;

		Queue<Integer> Q = new LinkedList<>();
		Q.offer(1);

		while (!Q.isEmpty()) {
			int nowNode = Q.poll();
			for (Integer cur : graph.get(nowNode)) {
				if (!visited[cur]) {
					Q.offer(cur);
					visited[cur] = true;
					distance[cur] = distance[nowNode] + 1;
				}
			}
		}

		int max = Arrays.stream(distance).max().getAsInt();

		for (int dis : distance) {
			if (dis == max) {
				answer++;
			}
		}

		return answer;
	}
}
