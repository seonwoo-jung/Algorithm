package com.study.algorithm.book.doit_middle.ch09_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_11725_트리의부모찾기 {

	private static int[] answer;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		tree = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}


		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		DFS(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void DFS(int number) {
		visited[number] = true;
		for (int x : tree.get(number)) {
			if (!visited[x]) {
				answer[x] = number;
				DFS(x);
			}
		}
	}
}
