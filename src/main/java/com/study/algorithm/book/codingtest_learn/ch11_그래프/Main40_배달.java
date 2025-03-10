package com.study.algorithm.book.codingtest_learn.ch11_그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main40_배달 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}

	private static int solution(int N, int[][] road, int K) {
		ArrayList<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : road) {
			adjList[edge[0]].add(new Node(edge[1], edge[2]));
			adjList[edge[1]].add(new Node(edge[0], edge[2]));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(1, 0));
		dist[1] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.dest] < now.cost) {
				continue;
			}

			for (Node next : adjList[now.dest]) {
				if (dist[next.dest] > now.cost + next.cost) {
					dist[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= N; i++) {
			if (dist[i] <= K) answer++;
		}

		return answer;
	}

	private static class Node {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
