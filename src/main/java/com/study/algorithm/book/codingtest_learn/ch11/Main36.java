package com.study.algorithm.book.codingtest_learn.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Integer.MAX_VALUE;

public class Main36 {

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

		System.out.println("adjList = " + adjList);

		int[] dist = new int[n];
		Arrays.fill(dist, MAX_VALUE);

		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.dest] < now.cost) {
				continue;
			}

			for (Node next : adjList.get(now.dest)) {
				if (dist[next.dest] > now.cost + next.cost) {
					dist[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}

		return dist;
	}

	private static class Node {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
