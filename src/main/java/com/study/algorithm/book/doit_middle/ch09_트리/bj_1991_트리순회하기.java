package com.study.algorithm.book.doit_middle.ch09_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1991_트리순회하기 {

	private static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new int[26][2];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			int node = s[0].charAt(0) - 'A';
			char lt = s[1].charAt(0);
			char rt = s[2].charAt(0);

			if (lt == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = lt - 'A';
			}

			if (rt == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = rt - 'A';
			}
		}

		preOrder(0);
		System.out.println();

		inOrder(0);
		System.out.println();

		postOrder(0);
		System.out.println();
	}

	private static void preOrder(int now) {
		if (now == -1) {
			return;
		}
		System.out.print((char) (now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}

	private static void inOrder(int now) {
		if (now == -1) {
			return;
		}
		preOrder(tree[now][0]);
		System.out.print((char) (now + 'A'));
		preOrder(tree[now][1]);
	}

	private static void postOrder(int now) {
		if (now == -1) {
			return;
		}
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
		System.out.print((char) (now + 'A'));
	}
}
