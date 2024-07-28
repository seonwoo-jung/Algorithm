package com.study.algorithm.personal.dfs;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */
// 인접리스트
public class DFS4 {

	static int n, m, answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<>();

		// 객체 생성하기
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		ch = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b); // a번 ArrayList에 접근해서 add를 한다.
		}
		ch[1] = 1;
		DFS(1);
		System.out.println(answer);
	}


	static void DFS(int v) {
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
