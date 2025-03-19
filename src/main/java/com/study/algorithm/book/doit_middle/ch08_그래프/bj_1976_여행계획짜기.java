package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1976_여행계획짜기 {

	private static int[] parent;
	private static int[][] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		city = new int[N + 1][N + 1];
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] route = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 1) {
					union(i, j);
				}
			}
		}

		int index = find(route[1]);
		for (int i = 2; i < route.length; i++) {
			if (index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}
}