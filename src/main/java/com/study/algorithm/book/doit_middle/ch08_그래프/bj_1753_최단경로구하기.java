package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1753_최단경로구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		int[] dis = new int[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}

		Queue<Node> Q = new PriorityQueue<>();
		Q.offer(new Node(S, 0));
		dis[S] = 0;

		while (!Q.isEmpty()) {
			Node now = Q.poll();
			for (Node next : graph.get(now.vex)) {
				if (dis[next.vex] > next.cost + now.cost) {
					dis[next.vex] = next.cost + now.cost;
					Q.offer(new Node(next.vex, dis[next.vex]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dis[i]);
			}
		}
	}

	private static class Node implements Comparable<Node> {

		public int vex, cost;

		@Override
		public int compareTo(Node ob) {
			return this.cost - ob.cost;
		}

		public Node(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}
	}
}