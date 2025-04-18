package com.study.algorithm.inflearn.intro.ch07_recursive;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로탐색(인접리스트, ArrayList)
 */
public class Main13_경로탐색_인접리스트 {

	private static int n, m, answer = 0;
	private static ArrayList<ArrayList<Integer>> graph;
	private static int[] ch;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		ch = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}

		ch[1] = 1;
		DFS(1);
		System.out.println(answer);
	}

	private static void DFS(int v) {
		if (v == n) answer++;
		else {
			for (int nv : graph.get(v)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
	}
}
