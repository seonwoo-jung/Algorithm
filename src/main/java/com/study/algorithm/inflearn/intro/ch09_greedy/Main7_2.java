package com.study.algorithm.inflearn.intro.ch09_greedy;

import java.util.*;

import static java.lang.System.in;

/**
 * 윈더랜드 (최소 스패닝 트리 - 프림)
 */
public class Main7_2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		List<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		int[] ch = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}

		int answer = 0;

		Queue<Edge> PQ = new PriorityQueue<>();
		PQ.offer(new Edge(1, 0));

		while (!PQ.isEmpty()) {
			Edge cur = PQ.poll();
			// 도착 정점
			int ev = cur.vex;
			if (ch[ev] == 0) {
				ch[ev] = 1;
				answer += cur.cost;
				for (Edge next : graph.get(ev)) {
					if (ch[next.vex] == 0) {
						PQ.offer(new Edge(next.vex, next.cost));
					}
				}
			}
		}
		System.out.println("answer = " + answer);
	}

	private static class Edge implements Comparable<Edge> {

		public int vex;
		public int cost;

		public Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}

		// 비용을 기준으로 정렬
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
}