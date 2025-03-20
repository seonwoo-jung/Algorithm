package com.study.algorithm.book.doit_middle.ch09_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1068_리프노드의개수구하기 {

	private static ArrayList<ArrayList<Integer>> tree;
	private static boolean[] visited;
	private static int answer = 0;
	private static int deleteNode = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int root = 0;

		tree = new ArrayList<>();
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p != -1) {
				tree.get(i).add(p);
				tree.get(p).add(i);
			} else {
				root = i;
			}
		}
		deleteNode = Integer.parseInt(br.readLine());

		if (deleteNode == root) {
			System.out.println(0);
		} else {
			DFS(root);
			System.out.println(answer);
		}
	}

	private static void DFS(int number) {
		visited[number] = true;
		int cNode = 0;

		for (int x : tree.get(number)) {
			if (!visited[x] && x != deleteNode) {
				cNode++; // 자식수 세기
				DFS(x);
			}
		}
		// 자식이 없다 == 리프노드다
		if (cNode == 0) {
			answer++;
		}
	}
}
