package com.study.algorithm.personal.templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {
		int[] result = solution(new int[][]{
			{0, 1, 9},
			{0, 2, 3},
			{1, 0, 5},
			{2, 1, 1}
		},
			0,
			3);

		for (int i : result) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int[][] graph, int start, int n) {
		ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : graph) {
			adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
		}

		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);

		dis[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dis[now.dest] < now.cost) {
				continue;
			}

			for (Node next : adjList.get(now.dest)) {
				if (dis[next.dest] > now.cost + next.cost) {
					dis[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, dis[next.dest]));
				}
			}
		}

		return dis;
	}

	private static class Node {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
