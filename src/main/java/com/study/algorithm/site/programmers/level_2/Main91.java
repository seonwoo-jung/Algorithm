package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 다시보기
 */
public class Main91 {

	private static int[] dis;

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}

	private static int solution(int N, int[][] road, int K) {
		int answer = 0;
		List<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		dis = new int[N + 1];

		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int[] ints : road) {
			graph.get(ints[0]).add(new Edge(ints[1], ints[2]));
			graph.get(ints[1]).add(new Edge(ints[0], ints[2]));
		}

		Queue<Edge> PQ = new PriorityQueue<>();

		PQ.offer(new Edge(1, 0));
		dis[1] = 0;

		while (!PQ.isEmpty()) {
			Edge cur = PQ.poll();
			int now = cur.vex;
			int nowCost = cur.cost;

			if (nowCost > dis[now]) continue;

			for (Edge ob : graph.get(now)) {
				if (dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					PQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}

		System.out.println(Arrays.toString(dis));

		for (int i = 1; i <= N; i++) {
			if (dis[i] <= K) answer++;
		}

		return answer;
	}

	private static class Edge implements Comparable<Edge> {
		int vex, cost;

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

		public Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}
	}
}