package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main63 {

	private static ArrayList<ArrayList<Node>> adjList;

	public static void main(String[] args) {
		System.out.println(solution(5,
			new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		System.out.println(solution(6,
			new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3},
				{5, 6, 1}}, 4));
	}

	private static int solution(int N, int[][] road, int K) {
		adjList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : road) {
			adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Node> PQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

		PQ.add(new Node(1, 0));
		dist[1] = 0;

		while (!PQ.isEmpty()) {
			Node now = PQ.poll();

			if (dist[now.dest] < now.cost) {
				continue;
			}

			for (Node next : adjList.get(now.dest)) {
				if (dist[next.dest] > now.cost + next.cost) {
					dist[next.dest] = now.cost + next.cost;
					PQ.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K) {
				answer++;
			}
		}

		System.out.println(Arrays.toString(dist));

		return answer;
	}

	private static class Node {

		int dest;
		int cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
