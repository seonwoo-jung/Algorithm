package com.study.algorithm.inflearn.intro.ch07_recursive;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/**
 * 경로탐색(인접행렬)
 */
public class Main12_경로탐색_인접행렬 {

	private static int n, m, answer = 0;
	private static int[][] graph;
	private static int[] ch;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new int[n + 1][n + 1];
		ch = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = 1;
		}
		ch[1] = 1;
		DFS(1);
		out.println(answer);
	}

	private static void DFS(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int i = 1; i <= n; i++) {
				if (graph[v][i] == 1 && ch[i] == 0) {
					ch[i] = 1;
					DFS(i);
					ch[i] = 0;
				}
			}
		}
	}
}