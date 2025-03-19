package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1916_최소비용구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		int[] dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Queue<Node> Q = new PriorityQueue<>();
		Q.offer(new Node(s, 0));
		dis[s] = 0;

		while (!Q.isEmpty()) {
			Node now = Q.poll();

			// now.cost는 현재 vex까지 도달한 비용을 의미
			if (now.cost > dis[now.vex]) continue;

			for (Node next : graph.get(now.vex)) {
				if (dis[next.vex] > next.cost + now.cost) {
					dis[next.vex] = next.cost + now.cost;
					Q.offer(new Node(next.vex, dis[next.vex]));
				}
			}
		}

		System.out.println(dis[e]);
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