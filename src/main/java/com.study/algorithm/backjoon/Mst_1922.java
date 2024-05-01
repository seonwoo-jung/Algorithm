package com.study.algorithm.backjoon;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Collections.sort;

public class Mst_1922 {

	static int[] unf;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		unf = new int[n + 1];
		ArrayList<Edge> list = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			list.add(new Edge(a, b, c));
		}

		for (int i = 1; i <= n; i++) {
			unf[i] = i;
		}

		int answer = 0;
		sort(list);

		for (Edge ob : list) {
			int fa = Find(ob.v1);
			int fb = Find(ob.v2);

			if (fa != fb) {
				answer += ob.cost;
				Union(ob.v1, ob.v2);
			}
		}
		System.out.println(answer);
	}

	static int Find(int v) {
		if (unf[v] == v) {
			return v;
		} else {
			return unf[v] = Find(unf[v]);
		}
	}

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

		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
}
