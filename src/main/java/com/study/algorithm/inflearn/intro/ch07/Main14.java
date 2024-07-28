package com.study.algorithm.inflearn.intro.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 그래프 최단거리(BFS)
 */
public class Main14 {

	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch, dis;

	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			for (int nv : graph.get(cv)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt(); // 정점의 수
		m = kb.nextInt(); // 간선의 수
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		ch = new int[n + 1];
		dis = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}

		BFS(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}
}
