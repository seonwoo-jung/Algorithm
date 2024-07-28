package com.study.algorithm.inflearn.intro.ch09;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Collections.sort;

/**
 * 윈더랜드(최소 스패닝 트리(간선의 가중치가 제일 최소가 되도록 하는 것) - 크루스칼 : Uion&Find 이용)
 * 회로(다시 돌아갈 수 있는)의 유무에 따라서 그래프인지 트리인지 나뉨
 */
public class Main7 {

	static int[] unf;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		unf = new int[n + 1];
		ArrayList<Edge> arr = new ArrayList<>();

		for (int i = 1; i <= n; i++) unf[i] = i;

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Edge(a, b, c));
		}

		int answer = 0;

		// cost를 기준으로 오름차순 정렬
		sort(arr);

		for (Edge ob : arr) {
			System.out.printf("%d %d %d\n", ob.v1, ob.v2, ob.cost);
		}

		for (Edge ob : arr) {
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
	static int Find(int v) {
		if (v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}

	// 외워두기
	static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) unf[fa] = fb;
	}

	static class Edge implements Comparable<Edge> {

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