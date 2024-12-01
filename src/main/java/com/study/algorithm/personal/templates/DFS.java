package com.study.algorithm.personal.templates;


import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
	private static int n, m, answer = 0;
	private static ArrayList<ArrayList<Integer>> graph;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}

		visited[1] = true;
		DFS(1);
		System.out.println(answer);
	}

	private static void DFS(int v) {
		if (v == n) answer++;
		else {
			for (int nv : graph.get(v)) {
				if (!visited[nv]) {
					visited[nv] = true;
					DFS(nv);
					visited[nv] = false;
				}
			}
		}
	}
}
