package com.study.algorithm.personal.study.study0926;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 윈더랜드 (최소 스패닝 트리 - 크루스칼)
 */
public class Kruskal {

	private static int[] unf;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		unf = new int[n + 1];
		ArrayList<Edge> graph = new ArrayList<>();

		// 배열 unf에 정점 입력
		for (int i = 1; i <= n; i++) {
			unf[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			graph.add(new Edge(a, b, c));
		}

		int answer = 0;

		// cost를 기준으로 오름차순 정렬
		Collections.sort(graph);

		for (Edge ob : graph) {
			int fv1 = Find(ob.v1);
			int fv2 = Find(ob.v2);

			if (fv1 != fv2) {
				answer += ob.cost;
				Union(ob.v1, ob.v2); // 한 집합으로 묶는다.
			}
		}

		System.out.println(answer);
	}

	// 외워두기
	private static int Find(int v) {
		if (v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}

	// 외워두기
	private static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) unf[fa] = fb;
	}

	private static class Edge implements Comparable<Edge> {

		private int v1, v2, cost;

		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		// 비용을 기준으로 정렬
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
}