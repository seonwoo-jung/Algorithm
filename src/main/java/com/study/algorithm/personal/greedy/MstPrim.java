package com.study.algorithm.personal.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 */
public class MstPrim {

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
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

		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));

		while (!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int ev = tmp.vex;
			if (ch[ev] == 0) {
				ch[ev] = 1;
				answer += tmp.cost;
				for (Edge ob : graph.get(ev)) {
					if (ch[ob.vex] == 0) pQ.offer(new Edge(ob.vex, ob.cost));
				}
			}
		}
		System.out.println(answer);
	}

	static class Edge implements Comparable<Edge> {
		private int vex, cost;

		public Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}