package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1854_K번째최단경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		PriorityQueue<Integer>[] dis = new PriorityQueue[N + 1];

		for (int i = 0; i <= N; i++) {
			dis[i] = new PriorityQueue<>(K, Comparator.reverseOrder());
		}

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node(e, w));
		}

		Queue<Node> Q = new PriorityQueue<>();
		Q.offer(new Node(1, 0));
		dis[1].add(0);

		while (!Q.isEmpty()) {
			Node now = Q.poll();
			for (Node next : graph.get(now.vex)) {
				if (dis[next.vex].size() < K) {
					dis[next.vex].add(next.cost + now.cost);
					Q.offer(new Node(next.vex, next.cost + now.cost));
				} else if (dis[next.vex].peek() > next.cost + now.cost) {
					dis[next.vex].poll();
					dis[next.vex].add(next.cost + now.cost);
					Q.offer(new Node(next.vex, next.cost + now.cost));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (dis[i].size() == K) {
				System.out.println(dis[i].poll());
			} else {
				System.out.println("-1");
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